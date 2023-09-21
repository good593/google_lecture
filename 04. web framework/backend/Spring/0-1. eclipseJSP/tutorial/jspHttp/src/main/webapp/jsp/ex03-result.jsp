<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈 요청 결과</title>
</head>
<body>
<%
	String n1Str = request.getParameter("n1");
	String n2Str = request.getParameter("n2");
	
	int n1 = Integer.parseInt(n1Str);
	int n2 = Integer.parseInt(n2Str);
	
	int sumResult = n1 + n2;
%>
<h2>
	덧셈 결과 
</h2>
<h3>
	<%=n1 %> + <%=n2 %> = <%=sumResult %>
</h3>

</body>
</html>