package common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class JdbcUtil {

	private static JdbcUtil instance = new JdbcUtil();
	private static DataSource ds;
	
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공 ");
			
			InitialContext ctx = new InitialContext();
			Context envContext  = (Context)ctx.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/board");
			System.out.println("Connection Pool 생성 ");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	private JdbcUtil() {}
	
	public static JdbcUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection(); //Pool에서 커넥션 반환 
	}
}
