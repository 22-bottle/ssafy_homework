<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set value="123456789.12" var="num"></c:set>
<jsp:useBean id="date" class="java.util.Date" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
		<fmt:formatNumber type="number" value="${num }" maxFractionDigits="3"/><br>
		<fmt:formatNumber type="currency" value="${num }" maxFractionDigits="3"/><br>
		${date }<br>
		<fmt:formatDate value="${date }" type="date"/><br>
		<fmt:formatDate value="${date }" type="time"/><br>
		<fmt:formatDate value="${date }" type="both"/>
	</div>
</body>
</html>






