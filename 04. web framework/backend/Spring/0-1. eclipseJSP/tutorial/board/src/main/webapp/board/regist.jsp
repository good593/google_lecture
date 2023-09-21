<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="vo" class="board.BoardVO" />
<!-- title -> setTitle()을 이용해서 자동으로 데이터 매핑 -->
<jsp:setProperty name="vo" property="*" />
<jsp:useBean id="dao" class="board.BoardDao" />

<%
	request.setCharacterEncoding("utf-8");
	System.out.println("getTitle: "+vo.getTitle());
	dao.insertBoard(vo);
%>


<c:redirect url="${pageContext.request.contextPath}/list.jsp"></c:redirect>