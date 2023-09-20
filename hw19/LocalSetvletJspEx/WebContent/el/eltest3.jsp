<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setAttribute("id", "kim"); %>
	
	<div align="center">
		<pre>
			${id }
			${!empty id }
			${!empty name }	
			${4 + 10 }
			${4 > 10 }
			${4 eq 10 }
			${4 gt 1 }
			${4 lt 1 }
		
		</pre>
	</div>
</body>
</html>