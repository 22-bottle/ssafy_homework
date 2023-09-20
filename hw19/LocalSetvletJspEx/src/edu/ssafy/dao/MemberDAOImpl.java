package edu.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.util.DBUtil;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public boolean login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from members \n");
			sql.append("where user_id = ? \n"
					+ " and user_password = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return false;
	}

}
