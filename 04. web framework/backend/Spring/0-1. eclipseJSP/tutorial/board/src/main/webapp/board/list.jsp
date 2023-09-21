<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*, java.util.List" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	BoardDao dao = new BoardDao();
	List<BoardVO> lst = dao.selectAll();
	
	pageContext.setAttribute("boards", lst);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.num }</td>
			<td><a href="${pageContext.request.contextPath}/board/boardDetail.jsp?num=${board.num}">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.reg_date }</td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="./registForm.jsp"/>"><button>글 등록</button></a>
</body>
</html>
