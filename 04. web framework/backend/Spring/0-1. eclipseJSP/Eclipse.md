---
marp: true

---
# [이클리스 EE 설치](https://www.eclipse.org/downloads/packages/) 
- [참고문서](https://www.snugarchive.com/blog/java-eclipse-setup/)

---
- 이클립스 다운로드 

![Alt text](./img/eclipse/image-35.png)

---
- 학습용 폴더 이동 > 압출을 풀고 eclipse 실행 

![Alt text](./img/eclipse/image-36.png)

---
- workspace(jsp 공부폴더) 선택 후 lanche 실행 

![Alt text](./img/eclipse/image-37.png)

---
- 아래와 같이 `Eclipse IDE for Enterprise Java`와 같이 나와야 함  
![Alt text](./img/eclipse/image.png)

---
- 이클립스 구조 

![Alt text](./img/eclipse/image-38.png)

---
# 이클립스 세팅 
![Alt text](./img/eclipse/image-1.png)

---
## UTF-8로 인코딩 세팅
- General > workspace
![Alt text](./img/eclipse/image-2.png)

---
- Web > CSS
![Alt text](./img/eclipse/image-3.png)

---
- Web > HTML
![Alt text](./img/eclipse/image-4.png)

---
- Web > JSP
![Alt text](./img/eclipse/image-5.png)

---
## 톰켓 서버 세팅 
![Alt text](./img/eclipse/image-6.png)

---
![Alt text](./img/eclipse/image-7.png)

---
![Alt text](./img/eclipse/image-9.png)

---
![Alt text](./img/eclipse/image-10.png)

---
![Alt text](./img/eclipse/image-11.png)

---
![Alt text](./img/eclipse/image-12.png)

---
## 기본 브라우저 크롬으로 설정 
![Alt text](./img/eclipse/image-27.png)

---
# Dynamic Web Project 생성
- [[Error] Java compiler level does not match the version of the installed Java project facet 해결방법](https://hermeslog.tistory.com/248)
![Alt text](./img/eclipse/image-13.png)

---
![Alt text](./img/eclipse/image-23.png)

---
![Alt text](./img/eclipse/image-24.png)

---
![Alt text](./img/eclipse/image-25.png)

---
![Alt text](./img/eclipse/image-26.png)

---
![Alt text](./img/eclipse/Dynamic%20folder.png)

---
## jsp 파일 생성 
![Alt text](./img/eclipse/image-28.png)

---
![Alt text](./img/eclipse/image-29.png)

---
```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
안녕하세요~ 첫 번째 예제입니다.
현재시간은 <%= new java.util.Date() %> 입니다.
</body>
</html>
```

---
## 톰캣 서버 실행 

---
![Alt text](./img/eclipse/image-30.png)

---
![Alt text](./img/eclipse/image-31.png)

---
![Alt text](./img/eclipse/image-32.png)

---
![Alt text](./img/eclipse/image-33.png)

---
![Alt text](./img/eclipse/image-34.png)