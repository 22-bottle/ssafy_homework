<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<% int a = 10; %>
<title>Insert title here</title>
</head>
<body>
	
	forward1.jsp
	<% 
		pageContext.setAttribute("op1", "11");
		String msg = (String) request.getParameter("msg");
		System.out.println(msg);
		request.setAttribute("msg", msg+" forward1 이 보냈습니다");
	%>
	
	<jsp:forward page="forward2.jsp"></jsp:forward>
	
	<script type="text/javascript">
		
	</script>
</body>
</html>