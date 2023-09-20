<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="edu.ssafy.dto.*, java.util.*" errorPage="jsp/error.jsp"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <% String root = request.getContextPath();
request.setAttribute("root", root); List<BoardDto>
  list = (List<BoardDto
    >)request.getAttribute("list"); //System.out.println(list); %>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Insert title here</title>
      </head>
      <body>
        <div align="center">
          <%@ include file="/include/header.jsp"%>
          <table border="1">
            <tr>
              <td>글번호</td>
              <td>아이디</td>
              <td>제목</td>
              <td>내용</td>
              <td>조회수</td>
              <td>등록일</td>
            </tr>
            <tr>
              <c:forEach items="${ list }" var="board" varStatus="i">
                <td>${ list.get(i).getArticleNo() }</td>
                <td>${ list.get(i).getSubject() }</td>
                <td>${ list.get(i).getUserId() }</td>
                <td>${ list.get(i).getContent() }</td>
                <td>${ list.get(i).getHit() }</td>
                <td>${ list.get(i).getRegisterTime() }</td>
                <td>
                  <a href="${ root }/board?action=view&articleno=${ list.get(i).getArticleNo() }"
                    >상세보기</a
                  >
                </td>
              </c:forEach>
            </tr>
          </table>
        </div>
        <script type="text/javascript"></script>
      </body></html></BoardDto
></BoardDto>
