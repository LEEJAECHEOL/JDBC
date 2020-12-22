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
	String id = "rorod";
	String pwd = "1234";
	session.setAttribute("idKey", id);
	session.setAttribute("pwdKey", pwd);
%>

세션이 생성되었습니다. <br/>
<a href="viewSessionInfo.jsp">여기로</a>
</body>
</html>