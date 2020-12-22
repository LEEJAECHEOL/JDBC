<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String)session.getAttribute("nameKey");
	if(name == null){
	
%>
<<script type="text/javascript">
	alert("로그인되지 않았습니다.");
	href.location = "sessionLogin.jsp";
</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 로그인</title>
</head>
<body>
<h2>로그인</h2>
<p>Log On Page</p>
<p><%=name %>님이 로그인 하셨습니다.</p>
<p><a href = "/shop/login?gubun=sessionLogoutProc">로그아웃</a></p>
</body>
</html>