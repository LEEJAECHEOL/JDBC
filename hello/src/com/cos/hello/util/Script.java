package com.cos.hello.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	
	public static void back(HttpServletResponse resp, String message) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "')");
		out.println("history.back();");
		out.println("</script>");
		out.flush();
	}
	
	public static void href(HttpServletResponse resp, String url, String message) throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('" + message + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
		out.flush();
	}
	
}
