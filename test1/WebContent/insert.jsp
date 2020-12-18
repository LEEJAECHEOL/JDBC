<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos.test1.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db insert</title>
</head>
<body>
<%
	Connection conn = DBConn.getConnection();
	String sql = "INSERT INTO users(username, password, email) VALUES (?, ?, ?)";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	String username = "test";
	String password = "1234";
	String email = "test@nate.com";
	pstmt.setString(1, username);
	pstmt.setString(2, password);
	pstmt.setString(3, email);
	int result = pstmt.executeUpdate();
%>
	<h3>result : <%=result %></h3>
</body>
</html>