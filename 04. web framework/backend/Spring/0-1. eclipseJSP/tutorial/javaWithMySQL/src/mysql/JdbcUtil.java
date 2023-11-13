package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcUtil {
	private static JdbcUtil instance = new JdbcUtil();
	private static Connection conn;
	
	private static String url = "jdbc:mysql://localhost:3306/examplesdb";
	private static String user = "urstory";
	private static String password = "u1234";
	
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공 ");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Pool 생성 ");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JdbcUtil() {}
	
	public static JdbcUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return conn; //Pool에서 커넥션 반환 
	}
	
	
}