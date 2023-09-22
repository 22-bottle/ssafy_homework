package com.ssafy.sample.model.service;

import java.sql.SQLException;

import com.ssafy.sample.dto.MemberDto;
import com.ssafy.sample.model.dao.MemberDao;
import com.ssafy.sample.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private static MemberService memberService = new MemberServiceImpl();
	private MemberDao memberDao;
	
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getMemberDao();
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public MemberDto loginMember(String userId, String userPw) throws SQLException {
		return memberDao.loginMember(userId, userPw);
	}
	
}
