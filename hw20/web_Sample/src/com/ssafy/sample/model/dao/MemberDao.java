package com.ssafy.sample.model.dao;

import java.sql.SQLException;

import com.ssafy.sample.dto.MemberDto;

public interface MemberDao {

	MemberDto loginMember(String userId, String userPw) throws SQLException;

}
