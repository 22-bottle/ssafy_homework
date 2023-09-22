<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${ pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	
	<div align="center">
		<table>
			<tr>
				<td>코드</td>
				<td>모델</td>
				<td>가격</td>
			</tr>
			<c:forEach items="${ list }" var="i">
				<tr>
					<td>${ i.code }</td>
					<td>${ i.model }</td>
					<td>${ i.price }</td>
					<td><a href="${ root }/product?action=view&code=${ i.code }">상세보기</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<%@ include file="/include/footer.jsp" %>
</body>
</html>