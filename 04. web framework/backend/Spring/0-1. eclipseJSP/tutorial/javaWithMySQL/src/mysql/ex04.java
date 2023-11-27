package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ex04 {
	// 데이터 조회!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		JdbcUtil ju = JdbcUtil.getInstance();
		try {
			conn = ju.getConnection();
			
			String sql = "select num, title, writer, content, reg_date, cnt from board_table;";
			ArrayList<BoardVO> lst = new ArrayList<BoardVO>();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
					rs.getInt("num"),
					rs.getString("title"),
					rs.getString("writer"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getInt("cnt")
				);
				
				System.out.println("각 데이터: "+vo.toString());
				lst.add(vo);
			}
			
			System.out.println("총 결과 수: "+Integer.toString(lst.size()));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			ju.closeAll(conn, pstmt, rs);
		}
	}

}