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
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			out.print(cookies[i].getName() + " : "+cookies[i].getValue());
			out.print("<br/>");
			if(cookies[i].getName().equals("loginok")&&cookies[i].getValue().equals("true")){
				// login 한 아이			
			}else{
				// login 안된 아이
			}
			cookies[i].setMaxAge(0);
		}
	%>
</body>
</html>