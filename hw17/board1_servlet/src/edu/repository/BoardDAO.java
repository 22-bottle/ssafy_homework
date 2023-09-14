package edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.etc.DBUtil;
import edu.vo.Board;

public class BoardDAO {
	
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {};
	public static BoardDAO getInstance() {
		if (dao == null) dao = new BoardDAO();
		return dao;
	}

	public void boardInsert(Board b) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into board (user_id, subject, content, hit)\n");
			sb.append("values (?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, b.getUserId());
			pstmt.setString(2, b.getSubject());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getHit());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
	}
	
	public List<Board> boardList() throws SQLException {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from board order by article_no\n");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board cur = new Board();
				cur.setArticleNo(rs.getString(1));
				cur.setUserId(rs.getString(2));
				cur.setSubject(rs.getString(3));
				cur.setContent(rs.getString(4));
				cur.setRegisterTime(rs.getString(5));
				list.add(cur);
			}
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
		} finally {
			DBUtil.getInstance().close(rs);
			DBUtil.getInstance().close(pstmt);
			DBUtil.getInstance().close(conn);
		}
		return list;
	}
	
}
