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
	String sql = "DELETE FROM users WHERE id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	int id = 3;
	pstmt.setInt(1, id);
	int result = pstmt.executeUpdate();
%>
	<h3>result : <%=result %></h3>
</body>
</html>