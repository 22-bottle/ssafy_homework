package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.BoardDto;

public interface BoardService {
	int writeArticle(BoardDto boardDto);
	List<BoardDto> listArticle();
	BoardDto viewArticle(int articleNo);
	void updateHit(int articleNo);
	public int deleteArticle(int articleNo);
	int updateArticle(BoardDto boardDto);
}
