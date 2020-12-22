<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("nameKey")){
				name = cookies[i].getValue();
			}
		}
		if(name.equals("")){
%>
<<script type="text/javascript">
	alert("로그인되지 않았습니다.");
	href.location = "cookieLogin.jsp";
</script>
<%
		}
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
<p><a href = "/shop/login?gubun=logoutProc">로그아웃</a></p>
</body>
</html>