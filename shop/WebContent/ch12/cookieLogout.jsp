<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	Cookie[] cookies = request.getCookies();
	for(int i = 0; i < cookies.length; i++){
		if(cookies[i].getName().equals("nameKey")){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
	}
 
 %>
 <script>
 alert("로그아웃 되었습니다.");
 href.location="cookieLogin.jsp";
 </script>