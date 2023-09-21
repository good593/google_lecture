<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청을 받음</title>
</head>
<body>
<%
	String name = request.getParameter("name"); 
	name = name.strip(); // 공백 제거 
	System.out.println("전송받은 값: "+ name);
	
	if (name.equals("JSP")) {
%>
	<%= name %> 는 사랑입니다. ^^
<%  } else { %>
	JSP가 아닙니다. ㅠㅠ 
<% } %>

</body>
</html>