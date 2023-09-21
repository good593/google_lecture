<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String[] pets = request.getParameterValues("pet");
	
	System.out.println("name: "+name);
	System.out.println("addr: "+addr);
	for (String pet: pets) {
		System.out.println("pet: "+pet);
	}
%>
</body>
</html>