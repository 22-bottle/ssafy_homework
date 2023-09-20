package edu.ssafy.dao;

import java.util.List;

import edu.ssafy.dto.BoardDto;


public interface BoardDao {

	int writeArticle(BoardDto boardDto);
	List<BoardDto> listArticle();
	BoardDto viewArticle(int articleNo);
	void updateHit(int articleNo);
	int deleteArticle(int articleNo);
	int updateArticle(BoardDto boardDto);
	
}
