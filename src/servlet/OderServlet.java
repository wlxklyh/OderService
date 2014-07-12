package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import ui.CanteenManager;

import music.MusicPlay;

import database.JDBC;


public class OderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  CanteenManager manager;
	public OderServlet(){
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
		super.doPost(request, response);

		String jsonString=request.getParameter("jsonString");
		String str=URLDecoder.decode(jsonString,"Utf-8");
		System.out.println("str = "+str);
		
		JSONArray jsonArray = JSONArray.fromObject(str);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			String accountPhone = jsonObject.getString("accountPhone");
			String orderID = jsonObject.getString("orderId");
			if (i == 0) {
				JDBC.insertOrder(jsonObject.getString("canteenPhone"), accountPhone,orderID);
//				System.out.println("" + jsonObject.getString("orderContent"));
			}
			if (jsonObject.getInt("orderNum") > 0) {
				JDBC.insertOrderFood(jsonObject.getInt("foodId"),
						jsonObject.getInt("orderNum"),orderID);
			}
		}
		
		
		MusicPlay.playOrder();
	}

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
		new Thread(){
			public void run(){
				manager = CanteenManager.getManager();
				if(!manager.isVisible())
					manager.setVisible(true);
			}
		}.start();
		
		PrintWriter out = response.getWriter();
		String method = request.getParameter("a");
		
		String tempStr=request.getQueryString();
		System.out.println("doGet1"+tempStr);
		
		
		if(method.equals("login")){
			String phone=request.getParameter("phone");
		   	String pwd=request.getParameter("password");
		   	String checkPw = JDBC.queryAccountPassword(phone);
		   	if(pwd.equals(checkPw))
		   	out.print("1");else out.print("0");
		}else if(method.equals("register")){
			String phone=request.getParameter("phone");
		   	String pwd=request.getParameter("password");
			if(JDBC.accountRegister(phone,pwd))
			out.print("1");else out.print("0");
		}else if(method.equals("canteenlist")){
			out.print(JDBC.getCanteenList().toString());
		}else if(method.equals("foodlist")){
			String phone=request.getParameter("canteenPhone");
			System.out.println(phone);
			out.print(JDBC.getFoodList(phone).toString());
			System.out.println(JDBC.getFoodList(phone).toString());
		}else if(method.equals("order")){
			
			tempStr=request.getQueryString();
			System.out.println("doGet2"+tempStr);

			String jsonString=request.getParameter("jsonString");
			String tag=URLDecoder.decode(jsonString,"Utf-8");
			System.out.println(tag);
//			
//			InputStream is = request.getInputStream(); 
//			DataInputStream input = new DataInputStream(is); 
//			String str =input.readUTF(); 
//			
//			System.out.println(str);
		}else if(method.equals("login1")){
			
		}else if(method.equals("login1")){
			String title;
			title = "linyanhou";
			out.println(title);
		}
	}
	
	//��½����
	public boolean login(String phone,String password){
		
		return true;
	}
	
	
}
