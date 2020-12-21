package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
// javax로 시작하는 패키지는 톰켓이 들고있는 라이브러리.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {
	
	// req와 res는 톰켓이 만들어준다. (사용자의 요청이 있을 때마다 만들어줌.)
	// req는 BufferedReader 할 수 있는 ByteStream
	// res는 BufferedWriter 할 수 있는 ByteStream
	
	// http://localhost:8000/hello/user 이 경로로 오면 아래 함수가 실행된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserController 실행됨.");
//		String gubun = req.getRequestURI();		// /hello/front
		String gubun = req.getParameter("gubun");	// ? 뒤에 있는 값을 파싱해줌.
		System.out.println(gubun);
		// 아래를 라우터라고 부른다.
		if(gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");	// 한번더 request
		} else if(gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if(gubun.equals("selectOne")) {
			resp.sendRedirect("user/selectOne.jsp");
		} else if(gubun.equals("updateOne")) {
			resp.sendRedirect("user/updateOne.jsp");
		}
//		resp.sendRedirect("auth/login.jsp");	// 500 에러 -> 개발자가 잘못함. 응답을 보낸 후 다시 응답을 보낼 수 없다.
	}
}
