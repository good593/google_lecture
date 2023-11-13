package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		int ret = -1;
		
		try {
			JdbcUtil ju = JdbcUtil.getInstance();
			conn = ju.getConnection();
			
			String sql = "update board_table set title = ?, writer = ? where num=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "title1");
			pstmt.setString(2, "Writer1");
			pstmt.setString(3, "1");
			ret = pstmt.executeUpdate();
			
			System.out.println("Update 결과: "+Integer.toString(ret));
			
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