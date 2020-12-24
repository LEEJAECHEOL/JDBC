
<%@page import="com.cos.hello.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>
<!-- 가독성이 좋지 못하고 협업할 때 힘들기 때문에 사용하지 않는다. -->
<%-- <h1>User Info</h1>
<%
	Users user = (Users)session.getAttribute("sessionUser");
	if(user == null){
%>
	<h3>인증되지 않았습니다.</h3>
<%
		/* out.println("인증되지 않았습니다."); */
	}else {
%>
	<h3>인증되었습니다.</h3>
<%
		/* out.println("인증되었습니다."); */
	}
%> --%>

<h1>User Info</h1>

<%-- <%
	String result = (String)request.getAttribute("result");

%>
<%=result %> --%>

<h1>${sessionScope.result }</h1>
<!-- requestScope는 적지 않는다. -->
<h1>${result}</h1>
<form method="post" action="user?gubun=deleteProc">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>유저네임</th>
			<th>패스워드</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>
			<input type="hidden" name = "id" value="${user.id }"/>
			${user.id }
			</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td>${user.email }</td>
		</tr>
	</table>
	<button>삭제</button>
</form>

</body>
</html>