const buttons = document.querySelectorAll("button");
const resultEl = document.getElementById("result");
const resultUserEL = document.getElementById("resultUser");
const resultComputerEL = document.getElementById("resultComputer");
const playerScoreEl = document.getElementById("user-score");
const computerScoreEl = document.getElementById("computer-score");
const gameObj = {
    "rock": "&#x1F44A;",
    "paper": "&#x1f590;",
    "scissors": "&#x270c;",
}

let playerScore = 0;
let computerScore = 0;

buttons.forEach((button) => {
    button.addEventListener("click", () => {
        // playRound(사용자의 입력값, 컴퓨터의 입력값)
        let computerSelection = computerPlay();
        const result = playRound(button.id, computerSelection);
        resultEl.textContent = result;
        
        resultUserEL.innerHTML = "사용자: "+gameObj[button.id];
        resultUserEL.id = button.id;
        resultComputerEL.innerHTML = "컴퓨터: "+gameObj[computerSelection];
        resultComputerEL.id = computerSelection;
    });
});

function computerPlay() {
    const choices = ["rock", "paper", "scissors"];
    const randomChoice = Math.floor(Math.random() * choices.length);
    return choices[randomChoice];
}

function playRound(playerSelection, computerSelection) {
    // 비겼을 때,
    if (playerSelection === computerSelection) {
        return "It's a tie!";
    } 
    // 사용자가 이겼을 때, 
    else if (
        (playerSelection === "rock" && computerSelection === "scissors") ||
        (playerSelection === "paper" && computerSelection === "rock") ||
        (playerSelection === "scissors" && computerSelection === "paper")
    ) {
        playerScore++; // 사용자 스코어를 증가!!!
        playerScoreEl.textContent = playerScore;
        return "You win! " + playerSelection + " beats " + computerSelection;
    } 
    // 컴퓨터가 이겼을 때, 
    else {
        computerScore++;
        computerScoreEl.textContent = computerScore;
        return "You lose! " + computerSelection + " beats " + playerSelection;
    }
}