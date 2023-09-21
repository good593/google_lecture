<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>

<% request.setCharacterEncoding("utf-8");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "jdbc:mysql://localhost:3306/examplesdb";
	String user = "urstory";
	String password = "u1234";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		
		System.out.println("MySQL 연결 성공 ");
		
		String sql = "show tables;";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("결과: "+rs.getString("Tables_in_examplesdb"));
		}
		
	} catch (Exception e) {
		System.out.println("MySQL 연결 오류: "+e.getMessage());
	} finally {
		if(pstmt != null) 
 			try{pstmt.close();}catch(SQLException sqle){}
 		if(conn != null) 
 			try{conn.close();}catch(SQLException sqle){}
	}
%>
</body>
</html>

