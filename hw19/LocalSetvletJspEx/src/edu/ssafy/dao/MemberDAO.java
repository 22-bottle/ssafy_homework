package edu.ssafy.dao;

import edu.ssafy.dto.BoardDto;

public interface MemberDAO {
	boolean login(String id, String pw);
}
