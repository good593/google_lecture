
// location
document.write("<h3>location</h3>");
document.write("현재 문서의 주소는 " + location.href + "입니다.<br>");
document.write("현재 문서의 호스트 이름은 " + location.hostname + "입니다.<br>");
document.write("현재 문서의 파일 경로명은 " + location.pathname + "입니다.<br>");

const openDocument = () => {
    location.assign("sub.html");
}

// 5초 뒤에 실행 
setTimeout(openDocument, 5000);