<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="price" value="1000,2000,3000,4000,5000"></c:set>
<c:set var="price2" value="1000:2000:3000:4000:5000"></c:set>
</head>
<body>
	<c:forEach items="${price }" var="p" varStatus="i">
		price : ${p } : ${i.count }<br>
	</c:forEach>
	<hr>
	<c:forEach begin="1" end="3" items="${price }" var="p" varStatus="i">
		price : ${p } : ${i.count }<br>
	</c:forEach>
	<hr>
	<c:forTokens delims=":" items="${price2 }" var="p" varStatus="i">
		price : ${p } : ${i.count }<br>
	</c:forTokens>		
</body>
</html>