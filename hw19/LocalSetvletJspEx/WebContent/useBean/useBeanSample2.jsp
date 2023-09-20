<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="edu.ssafy.dto.BoardDto" />
	<jsp:setProperty property="*" name="dto" />

	<table border="1">
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty property="userId" name="dto"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><jsp:getProperty property="subject" name="dto"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><jsp:getProperty property="content" name="dto"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="전송"></td>
		</tr>
	</table>
</body>
</html>