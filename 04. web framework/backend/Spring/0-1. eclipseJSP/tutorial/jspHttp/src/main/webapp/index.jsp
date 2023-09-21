<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
	<li>
		<!-- new ex01.jsp 와 같은 결과가 나타난다. -->
		<a href="/jspHttp/jsp/ex01.jsp">ex01.jsp</a>
	</li>
	<li>
		<a href="<%=request.getContextPath() %>/jsp/ex01.jsp">new ex01.jsp</a>
	</li>
	<li>
		<a href="<%=request.getContextPath() %>/jsp/ex02.jsp">ex02.jsp</a>
	</li>
	<li>
		<a href="<%=request.getContextPath() %>/jsp/ex03.jsp">ex03.jsp</a>
	</li>
	<li>
		<a href="<%=request.getContextPath() %>/jsp/ex04.jsp">ex04.jsp</a>
	</li>
	<li>
		<a href="<%=request.getContextPath() %>/jsp/ex05.jsp">ex05.jsp</a>
	</li>
</ol>
</body>
</html>