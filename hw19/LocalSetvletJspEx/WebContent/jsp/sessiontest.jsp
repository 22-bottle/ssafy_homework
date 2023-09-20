<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(session.isNew()){ %>
	<p>첫 방문이시군요</p>
	<%}else{ %>
	<p>또 방문이시군요</p>
	<%} %>
	<p>JSESSIONID : <%=session.getId() %></p>
	<%! int cnt; %>
	<% if(++cnt > 5){ session.invalidate();}%>
	<script type="text/javascript">
		
	</script>
</body>
</html>