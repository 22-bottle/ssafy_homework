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
		<form method="get" id='viewform'>
			<table border="1">
				<tr>
					<td>코드</td>
					<td><input type="text" name="code"
						value="${ product.code }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>모델</td>
					<td><input type="text" name="model"
						value="${ product.model }"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price"
						value="${ product.price }"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정" id="update">
						<input type="button" value="삭제" id="delete"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	
		document.querySelector("#delete").addEventListener("click", function(){
			location.href="${ root }/product?action=delete&code=" + viewform.code.value;
		});
		
		document.querySelector("#update").addEventListener("click", function(){
			let form = document.querySelector("#viewform");
			form.setAttribute("method", "get");
			form.setAttribute("action", "${ root }/product");
			form.submit();
		});
		
	</script>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>