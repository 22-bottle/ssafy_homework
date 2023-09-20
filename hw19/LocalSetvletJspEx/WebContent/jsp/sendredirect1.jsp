<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sendredirect1.jsp<br>
	<% 
		request.setAttribute("msg", "sendredirect");
		response.sendRedirect("sendredirect2.jsp");
	%>
</body>
</html>