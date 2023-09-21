package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.MemberDto;

public interface MemberService {

	MemberDto loginMember(String userId, String userPw) throws SQLException;

}
