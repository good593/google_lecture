package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int ret = -1;
		
		JdbcUtil ju = JdbcUtil.getInstance();
		try {
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
			
			ju.closeAll(conn, pstmt, rs);
		}
	}

}