<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <c:set var="root" value="${ pageContext.request.contextPath }"></c:set>
  </head>
  <body>
    <c:choose>
      <c:when test="${ !empty login }">
        <div align="right">
          안녕하세요 ${login } 님 반갑습니다 <a href="${ root }/member?action=logout">로그아웃</a>
        </div>
      </c:when>
      <c:otherwise>
        <div align="right">
          안녕하세요 로그인하세요 <a href="${ root }/member?action=loginform">로그인</a>
        </div>
      </c:otherwise>
    </c:choose>
    <c:if test="${!empty login }"> </c:if>
  </body>
</html>
