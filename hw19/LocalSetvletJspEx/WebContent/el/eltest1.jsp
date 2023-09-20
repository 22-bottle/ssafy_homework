<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.dto.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("name", "park");
	//request.setAttribute("name", "Lee");
	//session.setAttribute("name", "Kim");
	application.setAttribute("name", "son");	
	
	BoardDto dto = new BoardDto();
	dto.setUserId("dto");
	pageContext.setAttribute("dto", dto);
	%>
    
    <div align="center">
    	<p>
    		<%=pageContext.getAttribute("name") %><br>
    		pageScope : ${pageScope["name"] }  <br>
    		requestScope : ${requestScope.name }<br>
    		sessionScope : ${sessionScope.name }<br>
    		applicationScope : ${applicationScope.name }<br>
    		name : ${name }
    		<hr>
    		userid : ${pageScope.dto.userId }<br>
    		userid : ${pageScope["dto"]["userId"] }<br>
    		userid : ${dto["userId"] }
    	</p>
    
    </div>
    
</body>
</html>