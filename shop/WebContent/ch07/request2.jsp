<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String protocol = request.getProtocol();
	String serverName = request.getServerName();
	int serverPort = request.getServerPort();
	String remoteAddr = request.getRemoteAddr();
	String remoteHost = request.getRemoteHost();
	String method = request.getMethod();
	StringBuffer requestURL = request.getRequestURL();
	String requestURI = request.getRequestURI();
	String useBrowser = request.getHeader("User-Agent");
	String fileType = request.getHeader("Accept");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=protocol %></p><br/>
<p><%=serverName %></p><br/>
<p><%=serverPort %></p><br/>
<p><%=remoteAddr %></p><br/>
<p><%=remoteHost %></p><br/>
<p><%=method %></p><br/>
<p><%=requestURL %></p><br/>
<p><%=requestURI %></p><br/>
<p><%=useBrowser %></p><br/>
<p><%=fileType %></p><br/>

</body>
</html>