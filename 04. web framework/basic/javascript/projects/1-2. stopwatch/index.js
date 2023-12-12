const startEl = document.getElementById("start");
const stopEl = document.getElementById("stop");
const resetEl = document.getElementById("reset");

const timerEl = document.getElementById("timer");

let interval; // 값이 없음. 즉, false
let startTime = 0;

// 초기화 함수 
function init() {
    startTime = 0;
    updateTimer();
}

// 100 -> 1초 
// 6000 -> 1분 
function updateTimer() {

    let minutes = Math.floor(startTime / 6000); // 초 / 60 -> 분!!
    let left_times = startTime % 6000
    let seconds = Math.floor(left_times / 100);
    let miliseconds = left_times % 100; 
    let formattedTime = `${minutes.toString().padStart(2, "0")}:${seconds
        .toString().padStart(2, "0")}:${miliseconds
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
        startTime++; 
        updateTimer();

        // 1분이 지나면 멈추자!!
        if (startTime === 6000) {
            clearInterval(interval);
            alert("over 1 minutes!!");
            // init();
        }

    }, 10); // 0.01초에 한번씩 함수실행!!
}

function stopTimer() {
    clearInterval(interval);
}

function resetTimer() {
    // 기존에 있는 setInterval를 제거 
    clearInterval(interval);
    // 데이터 및 화면 초기화
    init();
}

startEl.addEventListener("click", startTimer);
stopEl.addEventListener("click", stopTimer);
resetEl.addEventListener("click", resetTimer);