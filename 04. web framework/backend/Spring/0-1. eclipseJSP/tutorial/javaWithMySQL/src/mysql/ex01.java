package mysql;

import java.sql.*;

public class ex01 {
	
	//	MySQL 접속!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/examplesdb";
		String user = "urstory";
		String password = "u1234";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("MySQL 연결 성공 ");
			
			String sql = "show tables;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String table_name = rs.getString("Tables_in_examplesdb");
				System.out.println("결과: "+table_name);
			}
			
		} catch (Exception e) {
			System.out.println("MySQL 연결 오류: "+e.getMessage());
		} finally {
			if(pstmt != null) 
	 			try{pstmt.close();}catch(SQLException sqle){}
	 		if(conn != null) 
	 			try{conn.close();}catch(SQLException sqle){}
		}
	}

}
