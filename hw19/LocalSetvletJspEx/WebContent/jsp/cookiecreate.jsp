<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// server 가 만들어서 브라우저에게 내려보낸다
		// 그러면 브라우저는 그대로 가지고 있다가 (how : 파일로 저장하고 있습니다) 
		// 쿠키를 만든 서버에 다시 접속하게 되면 
		// 쿠키를 그대로 서버에 전송한다
		Cookie c = new Cookie("id","park");
		Cookie c1 = new Cookie("pw","123");
		Cookie c2 = new Cookie("loginok","true");
		c.setMaxAge(60*60*12);
		response.addCookie(c);
		response.addCookie(c1);
		
	%>
	
	<h1>cookiecreate</h1>
	
	<script type="text/javascript">
		
	</script>
</body>
</html>