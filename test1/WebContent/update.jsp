<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos.test1.config.DBConn"%>
<%@page import="java.sql.Connection"%>
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
	Connection conn = DBConn.getConnection();
	String sql = "UPDATE users SET password = ? WHERE id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	int id = 3;
	String password = "12345";
	pstmt.setString(1, password);
	pstmt.setInt(2, id);
	int result = pstmt.executeUpdate();
%>
	<h3>result : <%=result %></h3>
</body>
</html>