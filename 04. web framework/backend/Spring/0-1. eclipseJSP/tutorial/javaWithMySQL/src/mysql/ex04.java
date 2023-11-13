package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ex04 {
	// 데이터 조회!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null; 
		Statement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			JdbcUtil ju = JdbcUtil.getInstance();
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