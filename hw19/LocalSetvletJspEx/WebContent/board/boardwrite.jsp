<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%@ include file="/include/header.jsp"%>
		<form  method="get" id='writeform'>
			<input type="hidden" name="action" value="register">
			<table border="1">
				<tr>
					<td>아이디</td><td><input type="text" name="userid"></td>
				</tr>
				<tr>	
					<td>제목</td><td><input type="text" name="subject"></td>
				</tr>
				<tr>	
					<td>내용</td><td><input type="text" name="content"></td>
				</tr>
				<tr>	
					<td><input type="reset" value="취소"></td><td><input type="button" value="등록" id="boardwrite"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	
		let button = document.querySelector("#boardwrite");
		button.addEventListener("click",function(){
			let form = document.querySelector("#writeform");
			form.setAttribute("method","post");
			form.setAttribute("action","<%=root %>/board");
			form.submit();
		});
	
	</script>
</body>
</html>