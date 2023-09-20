package edu.ssafy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.dao.MemberDAOImpl;
import edu.ssafy.service.MemberService;
import edu.ssafy.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private MemberService service;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new MemberServiceImpl();
	}
	String url = new String("index.jsp");
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		//localhost:8080/contextpath?action=''
		try {
			String action = request.getParameter("action");
			System.out.println(action);
			if(action != null) {
				if(action.equals("loginform")) {
					url = "member/loginform.jsp";
				}else if(action.equals("login")) {
					url = login(request,response);
				}else if(action.equals("logout")) {
					request.getSession().invalidate();
					url = "redirect:/index.jsp";
				}
				
			}else {
				url = new String("index.jsp");
			}
			
		}catch(Exception e) {
			request.setAttribute("exception", e);
			url = "error.jsp";
		}
		if(url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":")+1);
			url = request.getContextPath() + url;
			response.sendRedirect(url);
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		//1 파라미터 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String idsave = request.getParameter("idsave");
		//2 login
		boolean login = service.login(id, pw);
		if(login) {
			request.setAttribute("login", "true");
			request.getSession().setAttribute("login", id);
			if(idsave != null) {
				Cookie c = new Cookie("id", id);
				c.setMaxAge(60*60*24);
				response.addCookie(c);
			}else {
				Cookie[] cookies = request.getCookies();
				for (Cookie c : cookies) {
					if(c.getName().equals("id")) {
						System.out.println("1111111");
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
			return "redirect:/board?action=boardlist";
		}else {
			request.setAttribute("login", "false");
			return "index.jsp";
		}
		// 3 화면
	}

}
