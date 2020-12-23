<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String serverInfo = application.getServerInfo();
	String mimeType = application.getMimeType("request1.html");
	
	String realPath = application.getRealPath("/");
	application.log("application 내부 객체 로그 테스트");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=serverInfo %><br>
<%=mimeType %><br>
<%=realPath %><br>
</body>
</html>