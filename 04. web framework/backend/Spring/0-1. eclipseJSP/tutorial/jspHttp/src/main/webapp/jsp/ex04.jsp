<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./ex04-result.jsp" method="post">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="addr" placeholder="주소"><br>
		좋아하는 동물 <br>
		<input type="checkbox" name="pet" value="dog">강아<br>
		<input type="checkbox" name="pet" value="cat">고양이<br>
		<input type="checkbox" name="pet" value="shark">상어<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>