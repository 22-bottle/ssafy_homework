<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sendredirect2.jsp<br>
	<%
		String msg = (String)request.getAttribute("msg"); 
	%>
	<%=msg %>
</body>
</html>