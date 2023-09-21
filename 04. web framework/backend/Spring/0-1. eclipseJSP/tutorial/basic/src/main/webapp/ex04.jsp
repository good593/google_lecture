<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Life Cycle</title>
</head>
<body>
<%!
	// 선언문 영역 

	private int num1 = 0;
	public void jspInit() { // 오바라이딩 
		System.out.println("jspInit() 호출됨");
	}
	
	public void jspDestroy() { // 오바라이딩 
		System.out.println("jspDestroy() 호출됨");
	}
%>

<%
	// 연산 영역 

	int num2 = 0;
	num1++;
	num2++;
	
	// 서버톰캣에서 확인 
	System.out.println("코드수정!!");
	System.out.println("num1: "+num1);
	System.out.println("num2: "+num2);
%>

<!-- 브라우저 영역  -->
<ul>
	<li>>num1: <%= num1 %></li>
	<li>>num2: <%= num2 %></li>
</ul>

</body>
</html>