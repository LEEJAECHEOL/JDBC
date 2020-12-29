package com.cos.hello.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	// 1. workspace 환경이 utf-8
	// 2. html 파일이 utf-8
	// 3. jsp파일이 utf-8
	// 4. 응답헤더에 utf-8
	// 5. 요청헤더에 utf-8
	// 6. DB에 utf-8 (신경안써도 됨) 리눅스 : my.conf, 윈도우 : my.ini
	
	public static void back(HttpServletResponse resp, String message) throws IOException {
//		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "')");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}
	
	public static void href(HttpServletResponse resp, String url, String message) throws IOException {
//		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
		out.flush();
	}
	
}
