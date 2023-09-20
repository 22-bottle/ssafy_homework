<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="price" value="3000" scope="request"></c:set>
	price : ${price }<br>
	<c:set var="prices" value="3000,5000,6000,7000" scope="request"></c:set>
	prices : ${prices }<br>
	<c:forEach items="${prices }" var="p" varStatus="i">
		price : ${i.count} : ${p }<br>
		<c:set var="total" value="${total + p }"/>
	</c:forEach>
	<hr>
		${total }
	
</body>
</html>