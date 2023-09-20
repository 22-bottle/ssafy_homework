<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <% 
	BoardDto t = (BoardDto) session.getAttribute("dto");
%> --%>
<jsp:useBean id="dto" class="edu.ssafy.dto.BoardDto" scope="session" />
<jsp:useBean id="t" class="edu.ssafy.dto.BoardDto" scope="session" />
<jsp:setProperty property="userId" name="t" value="park"/>
<body>
	<div align="center">
		<pre>
		useBean2.jsp
		
		<%-- <%=dto.getSubject() %> --%>
		${dto.subject }
		<%-- <%=((BoardDto)session.getAttribute("t")).getUserId() %> --%>
		${t.userId }
		</pre>
	</div>
</body>
</html>