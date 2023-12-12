
document.body.style.background = "red";

// 3초 뒤에는 원상태로 복구!!
setTimeout(() => {
    document.body.style.background = ""
}, 3000);
