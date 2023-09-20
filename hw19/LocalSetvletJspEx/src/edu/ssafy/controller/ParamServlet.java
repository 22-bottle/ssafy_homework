package edu.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/paramservlet.do")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int a;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int op1 = Integer.parseInt(request.getParameter("op1"));
		int op2 = Integer.parseInt(request.getParameter("op2"));
		int res = op1 + op2;
    	PrintWriter out = response.getWriter();
    	out.println("<h1>"+res+"<h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int op1 = Integer.parseInt(request.getParameter("nop1"));
		int op2 = Integer.parseInt(request.getParameter("nop2"));
		int res = op1 + op2;
		
		String[] check = request.getParameterValues("check");
		if(check!=null) {
			for (String str : check) {
				System.out.println(str);
			}
		}
		
		PrintWriter out = response.getWriter();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<h1>"+op1 + " + " + op2 + " = "+res+"</h1>");
		out.println(sb.toString());
	}

}
