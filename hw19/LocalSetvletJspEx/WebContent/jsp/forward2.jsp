<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	forward2.jsp<br>
	<% 
		String msg1 =  request.getParameter("msg");
		String msg2 = (String) request.getAttribute("msg");
	%>
	
	msg1 : <%=msg1 %><br>
	msg2 : <%=msg2 %><br>
</body>
</html>