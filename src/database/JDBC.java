package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static final String DATABASE_ODER="myoder";
	
	private static final String TABLE_ACCOUNT="account";
	private static final String TABLE_CANTEEN="canteen";
	private static final String TABLE_ODER="oder";
	private static final String TABLE_FOOD="food";
	private static final String TABLE_ODERFOOD="oderfood";
	
	
	// 创建静态全局变量
	static Connection conn;
	static Statement st;

	public static void main(String[] args) {
//		insert(); // 插入添加记录
		// update(); //更新记录数据
		// delete(); //删除记录
		String pw = queryAccountPassword("13570233448");
		System.out.println(pw);
	}

	
	public static String queryAccountPassword(String phone){
		conn = getConnection(); 
		String result = "noresult";
		try {
			String sql = "SELECT * FROM  account where phone = "+phone;
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			while (rs.next()) { // 判断是否还有下一个数据
				// 根据字段名获取相应的值
				result = rs.getString("password");
			}
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		return result;
	}
	
	public static boolean accountRegister(String phone,String password){
		conn = getConnection();
		try {
			String sql = "INSERT INTO account(phone,name, password,oderNum)"
					+ " VALUES ("+phone+","+""+","+password+","+"0)"; //
			st = (Statement) conn.createStatement(); // 
			int count = st.executeUpdate(sql); //
			if(count==0)return false;
			else if(count==1)return true;
			conn.close(); // 关闭数据库连接
		} catch (SQLException e) {
			System.out.println("插入数据失败" + e.getMessage());
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public static String getCanteenList(String phone){
		
		
		return "";
	}
	
	
	
	
	
	
	
	
	/* 插入数据记录，并输出插入的数据记录数 */
	public static void insert() {

		conn = getConnection(); // 首先要获取连接，即连接到数据库

		try {
			String sql = "INSERT INTO staff(ID,name, age)"
					+ " VALUES (12,'Tom1', 32)"; // 插入数据的sql语句

			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象

			int count = st.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数

			System.out.println("向staff表中插入 " + count + " 条数据"); // 输出插入操作的处理结果

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("插入数据失败" + e.getMessage());
		}
	}

	/* 更新符合要求的记录，并返回更新的记录数目 */
	public static void update() {
		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "update staff set wage='2200' where name = 'lucy'";// 更新数据的sql语句

			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

			System.out.println("staff表中更新 " + count + " 条数据"); // 输出更新操作的处理结果

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("更新数据失败");
		}
	}

	/* 查询数据库，输出符合要求的记录的情况 */
	public static void query() {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "select * from staff"; // 查询数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			ResultSet rs = st.executeQuery(sql); // 执行sql查询语句，返回查询数据的结果集
			System.out.println("最后的查询结果为：");
			while (rs.next()) { // 判断是否还有下一个数据

				// 根据字段名获取相应的值
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String depart = rs.getString("depart");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");

				// 输出查到的记录的各个字段的值
				System.out.println(name + " " + age + " " + sex + " " + address
						+ " " + depart + " " + worklen + " " + wage);

			}
			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
	}

	/* 删除符合要求的记录，输出情况 */
	public static void delete() {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "delete from staff  where name = 'lili'";// 删除数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量

			System.out.println("staff表中删除 " + count + " 条数据\n"); // 输出删除操作的处理结果

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("删除数据失败");
		}

	}

	/* 获取数据库连接的函数 */
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
		String url = "jdbc:mysql://localhost/myoder?user=root&password=&useUnicode=true&characterEncoding=8859_1";
		// myDB为数据库名
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; // 返回所建立的数据库连接
	}
}