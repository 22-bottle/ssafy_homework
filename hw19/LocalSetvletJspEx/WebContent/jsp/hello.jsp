<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 디렉티브 -->

<%! 
	// 디클리어레이션
	// 변수선언가능
	public int a = 10;
	// 메소드선언 가능
	protected void print(){
		
		System.out.println("Hello SSAFY!");
	}
	//print();
	// 클래스선언 가능
	class Hello{
		void print(){
			
		}
	}
	Hello h = new Hello();
	
%>    

<% 
	// 스크릿트릿
	// 변수는 선언가능
	int a = 10;
	//메소드, 클래스선언 불가능
	//메소드, 클래스 사용가능
	print();
	h.print();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello SSAFY</h1>
	<!-- 익스프레션 -->
	<h2><%=a%></h2>
</body>
</html>

<!-- 
	자바
	//
	/* */
	html
	느마마
	jsp
	<%-- --%>
	
 -->