<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieName = "";
	String id = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("idKey")){
				cookieName = cookies[i].getName();
				id = cookies[i].getValue();
			}
		}
		if(!id.equals("")){
%>
<script type="text/javascript">
	alert("로그인 되었습니다.");
	location.href = "cookieLoginOK.jsp";
</script>
<%
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Cookie 로그인</h2>
	<form method="post" action="/shop/login?gubun=loginProc">
		<table border="1", align="center" width=300>
			<tr>
				<td colspan="2" align="center">Login</td>
			</tr>
			<tr>
				<td align="center">ID</td>
				<td align="center"><input name="id"></td>
			</tr>
			<tr>
				<td align="center">NAME</td>
				<td align="center"><input name="name"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value ="login"><input type="reset" value ="reset"></td>
			</tr>
			
			
		</table>
	</form>
</body>
</html>