<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scop2.jsp</h1>
	<%
		String msg1 = (String) pageContext.getAttribute("msg");
		String msg2 = (String) request.getAttribute("msg");
		String msg3 = (String) session.getAttribute("msg");
		String msg4 = (String) application.getAttribute("msg");
	%>
	pageContext : <%=msg1 %><br>
	request : <%=msg2 %><br>
	session : <%=msg3 %><br>
	application : <%=msg4 %><br>
</body>
</html>