window.onload = function () {
  // localStorage에서 poll이름의 data 얻기.
  var poll = localStorage.getItem("poll");
  // 투표가 보여질 div
  var pollDiv = document.querySelector("#vote");
  if (poll) {
    // localStorage에서 얻은 문자열을 JSON객체로 변환.
    var vote = JSON.parse(poll);
    var sdate = vote.start_date; // 시작일.
    var edate = vote.end_date; // 종료일.
    var question = vote.question; // 질문.
    var answers = vote.answers; // 답변항목.
    // 투표 화면 구성.
    pollDiv.innerHTML = `<div class="vote_title">|당신의 선택|</div>`;
    pollDiv.innerHTML += `<div class="vote_question">${question}</div>`
    // 투표 화면에 투표양식 추가.
    let form = document.createElement("form");
    let div = document.createElement("div");
    div.className = "vote_answer";
    let ul = document.createElement("ul");
    form.appendChild(div);
    div.appendChild(ul);
    for (let i = 0; i < answers.length; i++) {
      ul.innerHTML += `<li><input type="radio" name="vote_answer" value="${answers[i]}"/>${answers[i]}</li>`;
    }
    form.innerHTML += `<div class="vote_button"><input type="submit" class="button btn_primary vote_button" value="투표하기" onclick="javascript:poll()"/><button class="button">결과보기</button></div>`;
    pollDiv.appendChild(form);
    pollDiv.innerHTML += `<div class="vote_date">투표기간:${sdate}~${edate}</div>`;
  } else {
    // 진행중인 투표가 없을 경우 화면 추가.
    pollDiv.innerHTML = '<div class="vote_title">진행중인 투표가 없습니다.</div>';
  }
};

// 투표 시작일과 종료일 날짜 형식. (yy.mm.dd)
function dateFormat(date) {
  var yymmdd = date.split("-");
  return yymmdd[0].substr(2, 2) + "." + yymmdd[1] + "." + yymmdd[2];
}

// 로그인
function login() {
  // 사용자 정보를 입력받는다.
  var userid = prompt("아이디입력", "ssafy");
  if (userid.length == 0) {
    alert("아이디 입력!!!");
    return;
  }
  var userpass = prompt("비밀번호입력", "1234");
  if (userpass.length == 0) {
    alert("비밀번호 입력!!!");
    return;
  }
  if (userid == "ssafy" && userpass == "1234") {
    alert("로그인 성공!!!");
    // id가 profile_img인 element의 src 속성의 값을 img/profile.png로 설정.
    document.querySelector("#profile_img").src = "img/profile.png";
    document.querySelector("#header_nav_confirm_off").style.display = "none";
    document.querySelector("#header_nav_confirm_on").style.display = "block";
  } else {
    alert("아이디 또는 비밀번호 확인!!!");
  }
}

// 로그아웃
function logout() {
  // id가 profile_img인 element의 src 속성의 값을 img/noimg.png로 설정.
  document.querySelector("#profile_img").setAttribute("src", "img/noimg.png");
  document.querySelector("#header_nav_confirm_on").setAttribute("style", "display: none");
  document.querySelector("#header_nav_confirm_off").setAttribute("style", "display: block");
}

//왼쪽 메뉴
var cnt = 0;
function slideDown(areaid) {
  // 지역별 메뉴를 클릭시 펼치기/접기
  if (areaid.style.display == "none") {
    areaid.style.display = "block";
    cnt++;
  } else if (areaid.style.display == "block") {
    areaid.style.display = "none";
    cnt--;
  }

  if (cnt == 4) {
    // 모든 메뉴가 펼쳐졌다면 전국매장접기 버튼 활성화
    document.querySelectorAll(".store_display_off")[0].style.display = "block";
    document.querySelectorAll(".store_display_on")[0].style.display = "none";
  } else {
    // 모든 메뉴가 접혔다면 전국매장펼치기 버튼 활성화
    document.querySelectorAll(".store_display_off")[0].style.display = "none";
    document.querySelectorAll(".store_display_on")[0].style.display = "block";
  }
}

function allSlide(onoff) {
  if (onoff == "on") {
    // 모든 매장 펼치기
    var subs = document.querySelectorAll(".store_item_sub");
    for (var i = 0; i < subs.length; i++) subs[i].style.display = "block";

    document.querySelectorAll(".store_display_off")[0].style.display = "block";
    document.querySelectorAll(".store_display_on")[0].style.display = "none";
    cnt = 4;
  } else {
    // 모든 매장 접기
    var subs = document.querySelectorAll(".store_item_sub");
    for (var i = 0; i < subs.length; i++) subs[i].style.display = "none";

    document.querySelectorAll(".store_display_off")[0].style.display = "none";
    document.querySelectorAll(".store_display_on")[0].style.display = "block";
    cnt = 0;
  }
}

//투표하기
function poll() {
  var votes = document.querySelectorAll('input[name="vote_answer"]');
  var sel_menu = "";
  for (let i = 0; i < votes.length; i++) {
    if (votes[i].checked) {
      sel_menu = votes[i].value;
    }
  }
  if (sel_menu == "") {
    alert("답변을 선택해주세요");
  } else {
    alert(sel_menu + "를 선택했습니다.");
  }
}

// 투표만들기
function pollMake() {
  // pollmake.html의 창아이디를 poll로 설정하고 가로 500, 세로 300인 창을 열기.
  window.open("pollmake.html", "poll", "width=500,height=300,top=300,left=400");
}

// 답변 항목 추가
function addAnswer() {
  var listDiv = document.querySelector("#poll_answer_list");

  var divEl = document.createElement("div"); // <div></div>
  divEl.setAttribute("class", "poll_answer_item"); // <div class="poll_answer_item"></div>
  var inputEl = document.createElement("input"); // <input/>
  inputEl.setAttribute("type", "text"); // <input type="text"/>
  inputEl.setAttribute("name", "answer"); // <input type="text" name="answer"/>
  var buttonEl = document.createElement("button");
  buttonEl.setAttribute("type", "button");
  buttonEl.setAttribute("class", "button");
  // 버튼에 click 이벤트 리스너 등록.
  

  buttonEl.appendChild(document.createTextNode("삭제"));

  divEl.appendChild(inputEl);
  divEl.appendChild(buttonEl);
  listDiv.appendChild(divEl);
}

// 투표 생성
function makePoll() {
  var sdate = document.querySelector("#start_date").value; // 시작일.
  var edate = document.querySelector("#end_date").value; // 종료일.
  if (!sdate || !edate) {
    // 시작, 종료일 유효성검사.
    alert("설문 기간 입력!!!");
    return;
  }

  var quest = document.querySelector("#question").value; // 질문.
  if (!quest) {
    // 질문 유효성검사.
    alert("질문 내용 입력!!!");
    return;
  }

  var answerInput = document.querySelectorAll('input[name="answer"]'); // 답변 항목.
  for (var i = 0; i < answerInput.length; i++) {
    // 답변항목 유효성검사.
    
  }

  var answers = [];
  for (var i = 0; i < answerInput.length; i++) {
    answers.push(answerInput[i].value); // 답변 배열에 입력 data 넣기.
  }

  // 입력 data를 이용하여 JSON객체 생성.
  var poll = {
    start_date: sdate,
    end_date: edate,
    question: quest,
    answers: answers
  };

  var poll_json = JSON.stringify(poll); // JSON객체를 문자열 변환.

  localStorage.setItem("poll", poll_json); // localStorage에 넣기.

  alert("투표를 생성합니다.");
  opener.document.location.reload(); // 부모창 새로고침.
  self.close();
}
