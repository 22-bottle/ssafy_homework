<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp<br/>
	
	<li><a href="<%=root %>/board/boardwrite.jsp">회원등록</a></li>
	<li><a href="<%=root %>/board?action=boardlist">회원리스트</a></li>
	<li><a href="<%=root %>/member?action=loginform">로그인</a></li>
	<%-- <% response.sendRedirect("board/boardwrite.jsp"); %> --%>
</body>
</html>