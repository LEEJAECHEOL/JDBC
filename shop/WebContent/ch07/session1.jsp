<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	session.setAttribute("idKey", id);
	session.setMaxInactiveInterval(60 * 5);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Session Example</h1>
	<form action="session1_1.jsp" method="post">
		1. 가장 조아하는 계절은 ? <br>
		<input type = "radio" name = "season" value ="봄">봄
		<input type = "radio" name = "season" value ="여름">여름
		<input type = "radio" name = "season" value ="가을">가을
		<input type = "radio" name = "season" value ="겨울">겨울
		<br>
		2. 가장 좋아하는 과일은? <br>
		<input type = "radio" name = "fruit" value ="수박">수박
		<input type = "radio" name = "fruit" value ="멜론">멜론
		<input type = "radio" name = "fruit" value ="사과">사과
		<input type = "radio" name = "fruit" value ="오렌지">오렌지
		<br>
		<input type="submit" value="결과보기">
		
	</form>
</body>
</html>