function login() {
    let id = prompt("아이디 입력");
    let pw = prompt("비밀번호 입력");
    if (id == "ssafy" && pw == "1234") {
        alert("로그인 성공!");
    } else {
        alert("로그인 실패");
    }
    document.querySelector("#header_nav_confirm_off").style.display = "none";
    document.querySelector("#header_nav_confirm_on").style.display = "block";
    document.querySelector("#profile_img").src = "img/profile.png";
}

function logout() {
    document.querySelector("#header_nav_confirm_on").style.display = "none";
    document.querySelector("#header_nav_confirm_off").style.display = "block";
    document.querySelector("#profile_img").src = "img/noimg.png";
}

function allSlide(onOff) {
    let all_area = [seoul, daejeon, gwangju, gumi];
    if (onOff == "on") {
        document.querySelector(".store_display_on").style.display = "none";
        document.querySelector(".store_display_off").style.display = "block";
        for (let i = 0; i < 4; i++) {
            if (all_area[i].style.display == "none") {
                slideDown(all_area[i]);
            }
        }
    } else if (onOff == "off") {
        document.querySelector(".store_display_off").style.display = "none";
        document.querySelector(".store_display_on").style.display = "block";
        for (let i = 0; i < 4; i++) {
            if (all_area[i].style.display == "block") {
                slideDown(all_area[i]);
            }
        }
    }
}

function slideDown(region) {
    if (region.style.display == "none") {
        region.style.display = "block";
    } else {
        region.style.display = "none";
    }
}

function pollMake() {
    window.open("pollmake.html", "mkpoll", "width=600, height=400, left=300, top=200");
}

function addAnswer() {
    let pollAnswerListDiv = document.querySelector("#poll_answer_list");

    let divEl = document.createElement("div");
    divEl.setAttribute("class", "poll_answer_item");
    
    let inputEl = document.createElement("input");
    inputEl.setAttribute("type", "text");
    inputEl.setAttribute("name", "answer");

    let buttonEl = document.createElement("button");
    buttonEl.setAttribute("type", "button");
    buttonEl.setAttribute("class", "button");
    buttonEl.appendChild(document.createTextNode("삭제"));
    buttonEl.addEventListener("click", function () {
      let parentEl = this.parentNode;
      pollAnswerListDiv.removeChild(parentEl);
    });

    divEl.appendChild(inputEl);
    divEl.appendChild(buttonEl);
    pollAnswerListDiv.appendChild(divEl);
}

function makePoll() {
    let question = document.querySelector("#question").value;
    if (!question) {
      alert("질문을 입력해주세요");
      return;
    }

    let answers = document.getElementsByName("answer");
    for (const answer of answers) {
      if (!answer.value) {
        alert("답변을 입력해주세요");
        return;
      }
    }
  
    let answerArr = [];
    for (const answer of answers) {
      answerArr.push(answer.value);
    }
  
    let poll = {
      question: question,
      answers: answerArr,
    };
  
    if (confirm("투표를 생성하시겠습니까?")) {
      localStorage.setItem("poll", JSON.stringify(poll));
      opener.location.reload();
      self.close();
    }
}