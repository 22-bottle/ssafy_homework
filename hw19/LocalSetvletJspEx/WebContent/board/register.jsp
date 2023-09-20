<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.dao.*, java.util.*"%>
<%!
	BoardDao dao = BoardDaoImpl.getBoardDao();
	int cnt;
%>

<%
	String userid = request.getParameter("userid");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	/* BoardDto dto = new BoardDto();
	dto.setUserId(userid);
	dto.setSubject(subject);
	dto.setContent(content);
	System.out.println(dto);
	cnt = dao.writeArticle(dto); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ cnt gt 0 }">
		<h1>잘 입력되었습니다</h1>
	</c:if>
	<c:if test="${ cnt lt 0 }">
		<h1>입력이 실패하였습니다</h1>
	</c:if>
	<h1><a href="/LocalSetvletJspEx/board/boardlist.jsp">목록화면으로</h1>
</body>
</html>