<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cook Cookie</title>
</head>
<body>
<%
	String cookieName = "myCookie";
	Cookie cookie = new Cookie(cookieName, "Apple");
	cookie.setMaxAge(60);	// 1분
	cookie.setValue("Melone");
	response.addCookie(cookie);
%>
<h1>Eample Cookie</h1>
쿠키를 만듭니다 <br/>
쿠키내용은 <a href="tasteCookie.jsp">여기로</a>
</body>
</html>