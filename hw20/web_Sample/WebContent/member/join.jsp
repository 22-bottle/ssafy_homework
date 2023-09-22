<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${ pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					<mark class="orange">회원가입</mark>
				</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<form id="form-join" method="POST" action="">
					<div class="mb-3">
						<label for="username" class="form-label">이름 : </label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="이름..." />
					</div>
					<div class="mb-3">
						<label for="userid" class="form-label">아이디 : </label> <input
							type="text" class="form-control" id="userid" name="userid"
							placeholder="아이디..." />
					</div>
					<div id="result-view" class="mb-3"></div>
					<div class="mb-3">
						<label for="userpwd" class="form-label">비밀번호 : </label> <input
							type="text" class="form-control" id="userpwd" name="userpwd"
							placeholder="비밀번호..." />
					</div>
					<div class="mb-3">
						<label for="pwdcheck" class="form-label">비밀번호확인 : </label> <input
							type="text" class="form-control" id="pwdcheck"
							placeholder="비밀번호확인..." />
					</div>
					<div class="col-auto text-center">
						<button type="button" id="btn-join"
							class="btn btn-outline-primary mb-3">회원가입</button>
						<button type="button" class="btn btn-outline-success mb-3">초기화</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
      let isUseId = false;
      let input = document.querySelector("#userid");
      let resultDiv = document.querySelector("#result-view");
      input.addEventListener("keyup", function () {
        let checkid = input.value;
        let len = checkid.length;
        if (len < 4 || len > 16) {
          isUseId = false;
          resultDiv.setAttribute("class", "mb-3 fw-bold text-dark");
          resultDiv.innerHTML = "아이디는 4자이상 16자이하입니다.";
        } else {
          let url = "${root}/user?action=idcheck&checkid=" + checkid;
          fetch(url)
            .then((response) => response.json())
            .then((data) => resultViewJSON(data));
        }
      });

      function resultViewText(data) {
        let val = data.split(",");
        let id = val[0];
        let cnt = val[1];
        if (cnt == 0) {
          isUseId = true;
          resultDiv.setAttribute("class", "mb-3 text-success");
          resultDiv.innerHTML = "<span class='fw-bold'>" + id + "</span>은 사용할 수 있습니다.";
        } else {
          isUseId = false;
          resultDiv.setAttribute("class", "mb-3 text-danger");
          resultDiv.innerHTML = "<span class='fw-bold'>" + id + "</span>은 사용할 수 없습니다.";
        }
      }

      function resultViewJSON(data) {
        if (data.cnt == 0) {
          isUseId = true;
          resultDiv.setAttribute("class", "mb-3 text-primary");
          resultDiv.innerHTML =
            "<span class='fw-bold'>" + data.checkid + "</span>은 사용할 수 있습니다.";
        } else {
          isUseId = false;
          resultDiv.setAttribute("class", "mb-3 text-warning");
          resultDiv.innerHTML =
            "<span class='fw-bold'>" + data.checkid + "</span>은 사용할 수 없습니다.";
        }
      }

      document.querySelector("#btn-join").addEventListener("click", function () {
        if (!document.querySelector("#username").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#userid").value) {
          alert("아이디 입력!!");
          return;
        } else if (!isUseId) {
          alert("아이디 중복 확인!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (
          document.querySelector("#userpwd").value != document.querySelector("#pwdcheck").value
        ) {
          alert("비밀번호 확인!!");
          return;
        } else {
          let form = document.querySelector("#form-join");
          form.setAttribute("action", "${root}");
          form.submit();
        }
      });
    </script>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>