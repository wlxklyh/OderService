package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

import database.JDBC;


public class OderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, resp);
		
	}

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
	    response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("a");
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
		}else if(method.equals("login1")){
			
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