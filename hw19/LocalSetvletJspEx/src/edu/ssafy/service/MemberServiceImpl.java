package edu.ssafy.service;

import edu.ssafy.dao.MemberDAO;
import edu.ssafy.dao.MemberDAOImpl;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao ;
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	
	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

}
