package edu.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.dao.BoardDao;
import edu.ssafy.dto.BoardDto;
import edu.ssafy.service.BoardService;
import edu.ssafy.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service ;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		service = new BoardServiceImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		try {
			if(action.equals("register")) {
				path = register(request, response);
				sendRedirect(request, response, path);
			}else if(action.equals("boardlist")) {
				path = boardList(request,response);
				forward(request,response,path);
			}else if(action.equals("view")) {
				path = boardView(request,response);
				forward(request,response,path);
			}else if(action.equals("delete")) {
				path = boardDelete(request,response);
				sendRedirect(request,response,path);
			}else if(action.equals("update")) {
				path = boardUpdate(request, response, path);
				sendRedirect(request,response,path);
			}
		}catch (Exception e) {
			// TODO: handle exception
			// error page forward
			
		}
    }
	private String boardUpdate(HttpServletRequest request, HttpServletResponse response, String path) {
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println(articleNo);
		BoardDto dto = new BoardDto();
		dto.setArticleNo(articleNo);
		dto.setUserId(userid);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int cnt = service.updateArticle(dto);
		return "/board?action=boardlist";
	}

	private String boardDelete(HttpServletRequest request, HttpServletResponse response) {
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		System.out.println(articleNo);
		int cnt = service.deleteArticle(articleNo);
		return "/board?action=boardlist";
	}

	private String boardView(HttpServletRequest request, HttpServletResponse response) {
		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		//System.out.println(articleNo);
		BoardDto dto = service.viewArticle(articleNo);
		request.setAttribute("dto", dto);
		return "/board/boardview.jsp";
	}

	private String boardList(HttpServletRequest request, HttpServletResponse response) {
		List<BoardDto> list = service.listArticle();
		request.setAttribute("list", list);
		return "/board/boardlist.jsp";
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		
		// 1 파라미터 처리
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// 2 로직처리
		BoardDto dto = new BoardDto();
		dto.setUserId(userid);
		dto.setSubject(subject);
		dto.setContent(content);
		service.writeArticle(dto);
		
		return "/board?action=boardlist";
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void sendRedirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
}
