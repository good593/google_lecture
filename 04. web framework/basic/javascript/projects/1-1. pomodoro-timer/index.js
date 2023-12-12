const startEl = document.getElementById("start");
const stopEl = document.getElementById("stop");
const resetEl = document.getElementById("reset");

const timerEl = document.getElementById("timer");

let interval; // 값이 없음. 즉, false
let timeLeft = 1500; // 25분(1500초)

function updateTimer() {
    let minutes = Math.floor(timeLeft / 60); // 초 / 60 -> 분!!
    let seconds = timeLeft % 60; // 초 % 60 -> 나눈값의 나머지는 초!!!
    let formattedTime = `${minutes.toString().padStart(2, "0")}:${seconds
        .toString()
        .padStart(2, "0")}`;

    // 남의 시간이 변경되는 코드....
    timerEl.innerHTML = formattedTime;
}

function startTimer() {
    // 기존 setInterval이 존재하면 제거하는 로직!!
    if (interval) {
    stopTimer();
    }
    // interval = setInterval의 식별할 수 있는 index 반환 
    // setInterval: 특정 시간 단위로 어떤 함수를 계속 실행함!!!
    interval = setInterval(() => {
        timeLeft--; // 함수가 실행될때마다 하나씩 줄어듬..
        // updateTimer를 통해서 화면에 변경된 시간을 적용!!!
        updateTimer();
        // 남은 시간이 0초가 되면, 더 이상 함수를 실행하지 않음!!
        if (timeLeft === 0) {
            clearInterval(interval);
            alert("Time's up!");
            timeLeft = 1500; // 초기화!!!
            updateTimer(); // 화면도 초기화!!!
        }
    }, 1000); // 1초에 한번씩 함수실행!!
}

function stopTimer() {
    clearInterval(interval);
}

function resetTimer() {
    // 기존에 있는 setInterval를 제거 
    clearInterval(interval);
    // 데이터 및 화면 초기화
    timeLeft = 1500;
    updateTimer();
}

startEl.addEventListener("click", startTimer);
stopEl.addEventListener("click", stopTimer);
resetEl.addEventListener("click", resetTimer);