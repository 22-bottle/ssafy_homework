<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("msg", "Hello"+" pageContext");
		request.setAttribute("msg", "Hello"+" request");
		session.setAttribute("msg", "Hello"+" session");
		application.setAttribute("msg", "Hello"+" application");
		
	%>

	<jsp:forward page="scop2.jsp"></jsp:forward>
</body>
</html>