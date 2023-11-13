package mysql;

import java.sql.*;

public class ex03 {
	// 데이터 삽입!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int ret = -1;
		
		try {
			JdbcUtil ju = JdbcUtil.getInstance();
			conn = ju.getConnection();
			
			String sql = "insert into board_table (title, writer, content) values(?, ?, ?);";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "title");
			pstmt.setString(2, "Writer");
			pstmt.setString(3, "Contents");
			ret = pstmt.executeUpdate();
			
			System.out.println("Insert 결과: "+Integer.toString(ret));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}