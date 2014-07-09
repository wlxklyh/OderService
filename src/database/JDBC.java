package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import store.DataChangeManager;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;

import data.CanteenInfo;
import data.FoodInfo;

public class JDBC {
	private static final String DATABASE_ODER = "food_order";

	private static final String TABLE_ACCOUNT = "account";
	private static final String TABLE_CANTEEN = "canteen";
	private static final String TABLE_ODER = "order";
	private static final String TABLE_FOOD = "food";
	private static final String TABLE_ODERFOOD = "orderfood";

	private final static String ERROR = "数据库出现错误";
	static Connection conn;
	static Statement st;

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = "[{\"foodId\":1,\"canteenPhone\":\"13546899774\",\"orderNum\":2},{\"foodId\":2,\"canteenPhone\":\"13546899774\",\"orderNum\":0},{\"foodId\":3,\"canteenPhone\":\"13546899774\",\"orderNum\":0},{\"foodId\":4,\"canteenPhone\":\"13546899774\",\"orderNum\":0}]";
//		JSONArray jsonArray = JSONArray.fromObject(str);
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//			if (i == 0) {
//				insertOrder(jsonObject.getString("canteenPhone"), "");
//			}
//			if (jsonObject.getInt("orderNum") > 0) {
//				insertOrderFood(jsonObject.getInt("foodId"),
//						jsonObject.getInt("orderNum"));
//			}
//			System.out.println("" + jsonObject);
//		}
		
		String str = "[{\"orderNum\":1,\"foodId\":1,\"canteenPhone\":\"13546899774\",\"orderId\":\"11469144236\"},{\"orderNum\":0,\"foodId\":2,\"canteenPhone\":\"13546899774\",\"orderId\":\"11469144236\"},{\"orderNum\":0,\"foodId\":3,\"canteenPhone\":\"13"
		+"546899774\",\"orderId\":\"11469144236\"},{\"orderNum\":0,\"foodId\":4,\"canteenPhone\":\"13546899774\",\"orderId\":\"11469144236\"}]";
		JSONArray jsonArray = JSONArray.fromObject(str);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			String accountPhone = jsonObject.getString("accountPhone");
			String orderID = jsonObject.getString("orderId");
			
			if (i == 0) {
				insertOrder(jsonObject.getString("canteenPhone"), accountPhone,orderID);
			}
			if (jsonObject.getInt("orderNum") > 0) {
				insertOrderFood(jsonObject.getInt("foodId"),
						jsonObject.getInt("orderNum"),orderID);
			}
			System.out.println("" + jsonObject);
		}

	}
	

	public static String queryAccountPassword(String phone) {
		conn = getConnection();
		String result = "noresult";
		try {
			String sql = "SELECT * FROM  account where phone = " + phone;
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("password");
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR);
		}

		return result;
	}
	
	//没有返回0，有返回非零
	public static int queryCanteenAccountPassword(String phone, String passwd) {
		conn = getConnection();
		int result = 0;
		try {
			String sql = "SELECT * FROM  canteen where phone = '" + 
					phone + "' and passwd = '" + passwd +"'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				result = 1;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR);
		}
		return result;
	}

	//给定餐厅电话，返回餐厅信息，除了密码
	public static CanteenInfo getCanteenInfo(String phone) {
		conn = getConnection();
		CanteenInfo can = new CanteenInfo();
		try {
			String sql = "SELECT * FROM  canteen where phone = '" + phone;
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				can.setPhone(rs.getString("phone"));
				can.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
				can.setLatitude(rs.getFloat("x"));
				can.setLongitude(rs.getFloat("y"));
				can.setPasswd(rs.getString("passwd"));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR);
		}
		return can;
	}
	
	public static boolean accountRegister(String phone, String password) {
		conn = getConnection();
		try {
			String sql = "INSERT INTO account(phone,name, password,orderNum)"
					+ " VALUES (" + phone + "," + "null" + ",'" + password
					+ "'," + "0)"; 
			System.out.println(sql);
			st = (Statement) conn.createStatement(); //
			int count = st.executeUpdate(sql); //
			if (count == 0)
				return false;
			else if (count == 1)
				return true;
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}
		DataChangeManager.getDataManager().DataIseart();
		return false;
	}

	public static JSONArray getCanteenList() {
		List list = new ArrayList();
		conn = getConnection();
		try {
			String sql = "SELECT * FROM  canteen";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				CanteenInfo can = new CanteenInfo();
				can.setPhone(rs.getString("phone"));
				can.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
				can.setLatitude(rs.getFloat("x"));
				can.setLongitude(rs.getFloat("y"));
				list.add(can);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR);
		}
		JSONArray jsonObj1 = JSONArray.fromObject(list);
		return jsonObj1;
	}

	public static JSONArray getFoodList(String phone) {
		List list = new ArrayList();
		conn = getConnection();
		try {
			String sql = "SELECT * FROM  food where canteenPhone='" + phone
					+ "'";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				FoodInfo food = new FoodInfo();

				food.setFoodId(rs.getInt("foodid"));
				food.setCanteenPhone(rs.getString("canteenPhone"));
				food.setName(rs.getString("name"));
				food.setIntroduce(rs.getString("introduce"));
				food.setStarNum(rs.getInt("foodid"));
				food.setMonthSale(rs.getInt("monthSale"));
				food.setPrice(rs.getDouble("price"));

				list.add(food);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}
		JSONArray jsonObj1 = JSONArray.fromObject(list);
		return jsonObj1;
	}

	public static boolean insertOrderFood(int foodId, int orderNum,String OrderId) {
		conn = getConnection();
		try {
			String sql = "INSERT INTO orderfood(foodID,num,OrderID)" + " VALUES ("
					+ foodId + "," + orderNum +","+ OrderId+")";
			System.out.println(sql);
			st = (Statement) conn.createStatement(); //
			int count = st.executeUpdate(sql); //
			if (count == 0)
				return false;
			else if (count == 1)
				return true;
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}
		DataChangeManager.getDataManager().DataIseart();
		return false;
	}

	public static boolean  insertOrder(String canteenPhone, String accountPhone, String orderId) {
		conn = getConnection();
		try {
			String sql = "INSERT INTO `order`(`accountPhone`, `canteentPhone`, `orderID`)"
					+ " VALUES (" + canteenPhone + "," + accountPhone +"," + orderId + ")";
			System.out.println(sql);
			st = (Statement) conn.createStatement();
			int count = st.executeUpdate(sql);
			if (count == 0)
				return false;
			else if (count == 1){
				DataChangeManager.getDataManager().DataIseart();
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}
		return false;
	}

	
	
	
	
	
	
	
	public static void insert() {

		conn = getConnection();

		try {
			String sql = "INSERT INTO staff(ID,name, age)"
					+ " VALUES (12,'Tom1', 32)";

			st = (Statement) conn.createStatement();

			int count = st.executeUpdate(sql);

			System.out.println("��staff���в��� " + count + " �����");

			conn.close();

		} catch (SQLException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public static void update() {
		conn = getConnection();
		try {
			String sql = "update staff set wage='2200' where name = 'lucy'";

			st = (Statement) conn.createStatement();

			int count = st.executeUpdate(sql);

			System.out.println("staf" + count + " �����");

			conn.close(); //

		} catch (SQLException e) {
			System.out.println(ERROR);
		}
	}

	public static void query() {

		conn = getConnection();
		try {
			String sql = "select * from staff";
			st = (Statement) conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String depart = rs.getString("depart");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");

				System.out.println(name + " " + age + " " + sex + " " + address
						+ " " + depart + " " + worklen + " " + wage);

			}
			conn.close();

		} catch (SQLException e) {
			System.out.println(ERROR);
		}
	}

	public static void delete() {

		conn = getConnection();
		try {
			String sql = "delete from staff  where name = 'lili'";
			st = (Statement) conn.createStatement();

			int count = st.executeUpdate(sql);

			System.out.println("staff����ɾ�� " + count + " �����\n");

			conn.close();

		} catch (SQLException e) {
			System.out.println("ɾ�����ʧ��");
		}

	}

	public static Connection getConnection() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/"
				+ DATABASE_ODER
				+ "?user=root&password=scut623448&useUnicode=true&characterEncoding=gb2312";
		// myDBΪ��ݿ���
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; //
	}

}