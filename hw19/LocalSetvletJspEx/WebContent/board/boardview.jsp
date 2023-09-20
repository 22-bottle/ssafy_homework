<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.dto.*, java.util.*"
	errorPage="jsp/error.jsp"%>

<%
	String root = request.getContextPath();
	BoardDto dto = (BoardDto) request.getAttribute("dto");
	//System.out.println(list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%@ include file="/include/header.jsp"%>
		<form method="get" id='viewform'>
			<input type="hidden" id="articleno" name="articleno" value="<%=dto.getArticleNo() %>">
			<input type="hidden" name="action" value="update">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="<%=dto.getUserId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="<%=dto.getSubject()%>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content" value="<%=dto.getContent()%>"></td>
				</tr>
				<tr >
					<td colspan="2">
						<input type="button" value="수정" id="update">
						<input type="button" value="삭제" id="delete">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	
		document.querySelector("#delete").addEventListener("click",function(){
			location.href="<%=root%>/board?action=delete&articleno="+viewform.articleno.value;
		});
		
		document.querySelector("#update").addEventListener("click",function(){
			console.log("1111");
			let form = document.querySelector("#viewform");
			form.setAttribute("method","get");
			form.setAttribute("action","<%=root%>/board");
			form.submit();
		});
		
	</script>
	
</body>
</html>