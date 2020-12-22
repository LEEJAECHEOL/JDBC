package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
// javax로 시작하는 패키지는 톰켓이 들고있는 라이브러리.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.cos.hello.model.Users;

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
	
	private void route(String gubun, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");	// 한번더 request
		} else if(gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if(gubun.equals("selectOne")) {	// 유저정보 보기
			// 인증이 필요한 페이지
			HttpSession session = req.getSession();
			if(session.getAttribute("sessionUser") != null) {	// 인증끝
				Users user  = (Users)session.getAttribute("sessionUser");
				System.out.println("인증되었습니다.");
				System.out.println(user);
			}else {
				System.out.println("인증되지 않았습니다.");
			}
			resp.sendRedirect("user/selectOne.jsp");
		} else if(gubun.equals("updateOne")) {
			resp.sendRedirect("user/updateOne.jsp");
		} else if(gubun.equals("joinProc")) {	// 회원가입을 수행해줘
			// 데이터 원형 username=ssar&password=1234&email=ssar@nate.com
			// 1번 폼의 인풋태그에 있는 3가지 값 username,password,email값을 받기
			// getParameter()함수는 get방식과 post방식 데이터를 다 받을 수 있음
			// post방식에서는 데이터타입이 x-www-form-urlencoded방식만 받을 수 있음.
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			
			System.out.println("========= joinProc Start ===========");
			System.out.println(username);
			System.out.println(password);
			System.out.println(email);
			System.out.println("========= joinProc End ===========");
			// 2번 DB연결해서 3가지 값을 INSERT하기
			// 생략
			// 3번 INSERT가 정상적으로 되었다면 index.jsp를 응답!!
			resp.sendRedirect("index.jsp");
		} else if(gubun.equals("loginProc")) {
			// 1번 전달되는 값 받기
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			System.out.println("========= loginProc Start ===========");
			System.out.println(username);
			System.out.println(password);
			System.out.println("========= loginProc End ===========");
			// 2번 데이터베이스 값이 있는지 select해서 확인
			// 생략
			Users user = Users.builder()
					.id(1)
					.username(username)
					.build();
			// 3번 세션
			HttpSession session = req.getSession();
			// session에는 사용자패스워드 절대 넣지 않는다.
			session.setAttribute("sessionUser", user);
			// 모든 응답에는 Jsessionid가 쿠키로 추가됨.
			
//			resp.setHeader("Set-Cookie", "sessionKey=9998");
			// 4번 인덱스 페이지로 이동
			resp.sendRedirect("index.jsp");
		}
	}
}
