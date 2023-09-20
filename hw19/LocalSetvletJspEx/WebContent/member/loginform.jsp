<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:set var="root" value="<% request.getContextPath() %>"></c:set>
<c:set var="id" value="${cookie.id.value }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center" >
	
	<form action="${ root }/member?action=login" method="post">
		<table border="1">
			<tr><td>아이디</td><td><input type="text" name="id" value="${id }" > 
			<input type="checkbox" name="idsave" value='true' <c:if test="${!empty id }"> checked='checked' </c:if> > </td></tr>
			<tr><td>비밀번호</td><td><input type="password" name="pw"></td></tr>
			<tr><td colspan="2"><input type="submit" value="로그인"/></td></tr>
		</table>
	</form>	
	</div>
</body>
</html>