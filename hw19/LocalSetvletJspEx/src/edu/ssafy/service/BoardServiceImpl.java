package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dao.BoardDao;
import edu.ssafy.dao.BoardDaoImpl;
import edu.ssafy.dto.BoardDto;

public class BoardServiceImpl implements BoardService{
	private BoardDao dao;
	public BoardServiceImpl() {
		dao = BoardDaoImpl.getBoardDao();
	}
	@Override
	public int writeArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return dao.writeArticle(boardDto);
	}
	@Override
	public List<BoardDto> listArticle() {
		// TODO Auto-generated method stub
		return dao.listArticle();
	}
	@Override
	public BoardDto viewArticle(int articleNo) {
		// TODO Auto-generated method stub
		return dao.viewArticle(articleNo);
	}
	@Override
	public void updateHit(int articleNo) {
		dao.updateHit(articleNo);
		
	}
	@Override
	public int deleteArticle(int articleNo) {
		// TODO Auto-generated method stub
		return dao.deleteArticle(articleNo);
	}
	@Override
	public int updateArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return dao.updateArticle(boardDto);
	}
}
