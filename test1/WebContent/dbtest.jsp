<%@page import="com.cos.test1.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DataBase파일</title>
</head>
<body>
	<h1>데이터베이스 연결테스트</h1>
<%
	Connection conn = DBConn.getConnection();
	if(conn != null){
%>
		<h3>연결됨</h3>
<%
	}
%>
</body>
</html>