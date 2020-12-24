package com.cos.hello.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.dao.UsersDao;
import com.cos.hello.model.Users;
import com.cos.hello.util.Script;

public class UsersService {
	
	public void 회원가입(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 데이터 원형 username=ssar&password=1234&email=ssar@nate.com
		// 1번 폼의 인풋태그에 있는 3가지 값 username,password,email값을 받기
		// getParameter()함수는 get방식과 post방식 데이터를 다 받을 수 있음
		// post방식에서는 데이터타입이 x-www-form-urlencoded방식만 받을 수 있음.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		// 2번 DB연결해서 3가지 값을 INSERT하기
		Users user = Users.builder()
							.username(username)
							.password(password)
							.email(email)
							.build();
//		UsersDao usersDao = new UsersDao();	// 나중에 싱글톤 패턴으로 변경
		UsersDao usersDao = UsersDao.getInstance();
		int result = usersDao.insert(user);
		if(result == 1) {
			// 3번 INSERT가 정상적으로 되었다면 index.jsp를 응답!!
			resp.sendRedirect("auth/login.jsp");
		}else {
			resp.sendRedirect("auth/join.jsp");
		}
	}
	public void 로그인(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1번 전달되는 값 받기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 2번 데이터베이스 값이 있는지 select해서 확인
		UsersDao usersDao = UsersDao.getInstance();
		Users user = Users.builder()
				.username(username)
				.password(password)
				.build();
		Users userEntity = usersDao.login(user);
		if(userEntity == null) {
			// 한글 처리를 위해 resp객체를 건드린다.
			// MIME 타입
			// Http Header에 Content-Type	
			resp.setContentType("text/html;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");
			Script.back(resp, "로그인 실패");
		}else {
			// 3번 세션
			HttpSession session = req.getSession();
			resp.setContentType("text/html;charset=UTF-8");
			resp.setCharacterEncoding("UTF-8");
			Script.href(resp, "index.jsp", "로그인 성공");
			// session에는 사용자패스워드 절대 넣지 않는다.
			session.setAttribute("sessionUser", userEntity);
			// 모든 응답에는 Jsessionid가 쿠키로 추가됨.
//			resp.setHeader("Set-Cookie", "sessionKey=9998");
			// 4번 인덱스 페이지로 이동
		}
	}
	public void 유저정보보기(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 인증이 필요한 페이지
		HttpSession session = req.getSession();
		Users user = (Users)session.getAttribute("sessionUser");
		UsersDao usersDao = UsersDao.getInstance();
		if(user != null) {
			Users userEntity = usersDao.selectById(user.getId());
			req.setAttribute("user", userEntity);
			RequestDispatcher dis = req.getRequestDispatcher("user/selectOne.jsp");
			dis.forward(req, resp);
		}else {
			resp.sendRedirect("auth/login.jsp");
		}
	}
	public void 유저정보수정페이지(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 인증이 필요한 페이지
		HttpSession session = req.getSession();
		Users user = (Users)session.getAttribute("sessionUser");
		UsersDao usersDao = UsersDao.getInstance();
		if(user != null) {
			Users userEntity = usersDao.selectById(user.getId());
			req.setAttribute("user", userEntity);
			RequestDispatcher dis = req.getRequestDispatcher("user/updateOne.jsp");
			dis.forward(req, resp);
		}else {
			resp.sendRedirect("auth/login.jsp");
		}
	}
	public void 유저정보수정(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = ((Users)session.getAttribute("sessionUser")).getId();
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		Users user = Users.builder()
							.id(id)
							.password(password)
							.email(email)
							.build();
		UsersDao usersDao = UsersDao.getInstance();
		int result = usersDao.updateById(user);
		if(result == 1) {
			resp.sendRedirect("index.jsp");
		}else {
			resp.sendRedirect("user?gubun=updateOne");
		}
	}
	public void 유저정보삭제(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		UsersDao usersDao = UsersDao.getInstance();
		int result = usersDao.deleteById(id);
		if(result == 1) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}else {
			resp.sendRedirect("user?gubun=selectOne");
		}
		
	}
}
