<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>
<h1>회원정보 수정</h1>
<form method="post" action="/hello/user?gubun=updateProc">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>유저네임</th>
			<th>패스워드</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td><input type= "password" name="password" value="${user.password}"/></td>
			<td><input type= "text" name="email" value="${user.email}"/></td>
		</tr>
	</table>
	<button>회원수정</button>
</form>
</body>
</html>