package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;

public class BoardDao {

	private JdbcUtil ju;
	
	public BoardDao() {
		ju = JdbcUtil.getInstance();
	}
	
	// 삽입 (C)
	public int insertBoard(BoardVO vo) {
		int ret = -1;
		Connection con = null; 
		PreparedStatement pstmt = null;
		String sql = "insert into board_table (title, writer, content) values(?, ?, ?);";
		
		try {
			
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
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
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return ret;
	}
	// 조회 (R)
	public List<BoardVO> selectAll() {
		Connection con = null; 
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select num, title, writer, content, reg_date, cnt from board_table;";
		ArrayList<BoardVO> lst = new ArrayList<BoardVO>();
		
		try {
			
			con = ju.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO(
					rs.getInt("num"),
					rs.getString("title"),
					rs.getString("writer"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getInt("cnt")
				);
				
				lst.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lst;
	}
	
	// 조회 (R)
	public BoardVO selectOne(int num) {
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select num, title, writer, content, reg_date, cnt from board_table where num = ?;";
		BoardVO vo = null;
		
		try {
			
			con = ju.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO(
					rs.getInt("num"),
					rs.getString("title"),
					rs.getString("writer"),
					rs.getString("content"),
					rs.getDate("reg_date"),
					rs.getInt("cnt")
				);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return vo;
	}
	
	// 수정 (U)
	
	
	
	// 삭제 (D)
}
