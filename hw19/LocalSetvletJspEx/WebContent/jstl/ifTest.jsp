<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="user" value="guest"/>
</head>
<body>

	<c:if test="${user eq 'ssafy' }">
		<c:out value="${user } 님 안녕하세요"></c:out><br>
	</c:if>
	<c:if test="${user eq 'guest' }">
		<c:out value="${user } 님 안녕하세요"></c:out><br>
	</c:if>
	<c:if test="${!empty user}">
		<c:out value="이름을 입력하세요"></c:out><br>
	</c:if>
</body>
</html>