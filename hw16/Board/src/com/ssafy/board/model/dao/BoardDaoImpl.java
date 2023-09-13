package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private static BoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}

	public static BoardDao getBoardDao() {
		return boardDao;
	}

	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 board table에 insert 하세요!!!
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into board (user_id, subject, content)\n");
			sb.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
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
//		END
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return 하세요!!!
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
				BoardDto cur = new BoardDto();
				cur.setArticleNo(Integer.parseInt(rs.getString(1)));
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
//		END
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from board\n");
			sb.append("where subject like '%" + subject + "%'");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto cur = new BoardDto();
				cur.setArticleNo(Integer.parseInt(rs.getString(1)));
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
//		END
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		BoardDto boardDto = null;
//		TODO : board table에서 글번호가 no인 글 한개를 return 하세요!!!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from board\n");
			sb.append("where article_no = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(Integer.parseInt(rs.getString(1)));
				boardDto.setUserId(rs.getString(2));
				boardDto.setSubject(rs.getString(3));
				boardDto.setContent(rs.getString(4));
				boardDto.setRegisterTime(rs.getString(5));
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
//		END
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정하세요!!!
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update board set subject = ?, content = ?\n");
			sb.append("where article_no = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
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
//		END
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : board table에서 글번호가 no인 글 정보를 삭제하세요!!!
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from board\n");
			sb.append("where article_no = ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, no);
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
//		END
	}

}
