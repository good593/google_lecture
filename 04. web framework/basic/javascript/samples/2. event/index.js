
function countRabbits() {
    for(let i=1; i<=3; i++) {
        alert(`토끼 ${i}마리`);
    }
}

let hello = document.getElementById("hello");
hello.onclick = () => {
    alert("Hello World");
}

let who = document.getElementById("who");
who.onclick = function() {
    alert("슈퍼맨");
}

let food = document.getElementById("food");
food.onclick = () => {
    alert("족발 & 보쌈");
}

food.addEventListener("click",
    () => {
        alert("스테이크 & 파스타 & 빠에야");
    }
)

const handler = () => {
    alert("참치회, 초밥, 롤, 텐동");
}

food.addEventListener("click", handler);

const removeClick = () => {
    food.removeEventListener("click", handler)
}
setTimeout(
    removeClick, 5000
);

let obj = {
    handleEvent(event) {
        alert(`${event.type} 이벤트가 
            ${event.currentTarget}에서 발생했습니다.`);
    }
};

document.getElementById("objInput")
    .addEventListener("click", obj);


let spanTag = document.getElementById("spanTag")

let textObj = {
    handleEvent(event) {
        if(event.type === "mousedown") {
            spanTag.innerHTML = "마우스 버튼을 눌렀습니다.";
        } else if(event.type === "mouseup") {
            spanTag.innerHTML = "마우스 버튼을 뗐습니다.";
        }
    }
}

let textInput = document.getElementById("textInput")
textInput.addEventListener("mousedown", textObj);
textInput.addEventListener("mouseup", textObj);
