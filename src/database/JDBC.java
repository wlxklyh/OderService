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
	
	
	// ������̬ȫ�ֱ���
	static Connection conn;
	static Statement st;

	public static void main(String[] args) {
//		insert(); // ������Ӽ�¼
		// update(); //���¼�¼����
		// delete(); //ɾ����¼
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
			while (rs.next()) { // �ж��Ƿ�����һ������
				// �����ֶ�����ȡ��Ӧ��ֵ
				result = rs.getString("password");
			}
			conn.close(); // �ر����ݿ�����
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
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
			conn.close(); // �ر����ݿ�����
		} catch (SQLException e) {
			System.out.println("��������ʧ��" + e.getMessage());
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public static String getCanteenList(String phone){
		
		
		return "";
	}
	
	
	
	
	
	
	
	
	/* �������ݼ�¼���������������ݼ�¼�� */
	public static void insert() {

		conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�

		try {
			String sql = "INSERT INTO staff(ID,name, age)"
					+ " VALUES (12,'Tom1', 32)"; // �������ݵ�sql���

			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����

			int count = st.executeUpdate(sql); // ִ�в��������sql��䣬�����ز������ݵĸ���

			System.out.println("��staff���в��� " + count + " ������"); // �����������Ĵ�����

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("��������ʧ��" + e.getMessage());
		}
	}

	/* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ */
	public static void update() {
		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "update staff set wage='2200' where name = 'lucy'";// �������ݵ�sql���

			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���

			System.out.println("staff���и��� " + count + " ������"); // ������²����Ĵ�����

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("��������ʧ��");
		}
	}

	/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼����� */
	public static void query() {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "select * from staff"; // ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			ResultSet rs = st.executeQuery(sql); // ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
			System.out.println("���Ĳ�ѯ���Ϊ��");
			while (rs.next()) { // �ж��Ƿ�����һ������

				// �����ֶ�����ȡ��Ӧ��ֵ
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String depart = rs.getString("depart");
				String worklen = rs.getString("worklen");
				String wage = rs.getString("wage");

				// ����鵽�ļ�¼�ĸ����ֶε�ֵ
				System.out.println(name + " " + age + " " + sex + " " + address
						+ " " + depart + " " + worklen + " " + wage);

			}
			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
	}

	/* ɾ������Ҫ��ļ�¼�������� */
	public static void delete() {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "delete from staff  where name = 'lili'";// ɾ�����ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����

			System.out.println("staff����ɾ�� " + count + " ������\n"); // ���ɾ�������Ĵ�����

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("ɾ������ʧ��");
		}

	}

	/* ��ȡ���ݿ����ӵĺ��� */
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
		// myDBΪ���ݿ���
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; // ���������������ݿ�����
	}
}