package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// javax로 시작하는 패키지는 톰켓이 들고있는 라이브러리.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.model.Users;
import com.cos.hello.service.UsersService;

// 디스패쳐의 역할 = 분기 = 필요한 뷰를 응답해주는 것
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
		route(gubun, req, resp);
//		resp.sendRedirect("auth/login.jsp");	// 500 에러 -> 개발자가 잘못함. 응답을 보낸 후 다시 응답을 보낼 수 없다.
	}
	
	private void route(String gubun, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		UsersService usersService = new UsersService();
		if(gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");	// 한번더 request
		} else if(gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if(gubun.equals("selectOne")) {	// 유저정보 보기
			usersService.유저정보보기(req,resp);
		} else if(gubun.equals("updateOne")) {
			usersService.유저정보수정페이지(req,resp);
		} else if(gubun.equals("joinProc")) {	// 회원가입을 수행해줘
			usersService.회원가입(req, resp);
		} else if(gubun.equals("loginProc")) {
			// SELECT id, username, email FROM users WHERE username = ? AND password = ?
			// DAO 의 함수명 : login() return을 users오브젝트를 리턴
			// 정상이면 index.jsp 세션에 users오브젝트를 담고
			// 비정상 다시 로그인.jsp로 간다.
			usersService.로그인(req, resp);
		} else if(gubun.equals("updateProc")) {
			usersService.유저정보수정(req, resp);
		} else if(gubun.equals("deleteProc")) {
			usersService.유저정보삭제(req, resp);
		}
	}
}
