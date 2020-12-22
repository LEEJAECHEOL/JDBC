package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.LoginDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gubun = req.getParameter("gubun");
		if(gubun.equals("loginProc")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			LoginDao dao = new LoginDao();
			if(dao.loginRegister(id, name)) {
				Cookie cookie = new Cookie("nameKey", name);
				resp.addCookie(cookie);
				System.out.println("로그인이 되었습니다.");
				resp.sendRedirect("ch12/cookieLoginOK.jsp");
			}else {
				System.out.println("로그인 되지 않았습니다.");
				resp.sendRedirect("ch12/cookieLogin.jsp");
			}
			
		}else if(gubun.equals("logoutProc")) {

		 	Cookie[] cookies = req.getCookies();
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("nameKey")){
					cookies[i].setMaxAge(0);
					resp.addCookie(cookies[i]);
				}
			}
			System.out.println("로그아웃 되었습니다.");
			resp.sendRedirect("ch12/cookieLogin.jsp");
			
		}else if(gubun.equals("sessionLoginProc")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			LoginDao dao = new LoginDao();
			if(dao.loginRegister(id, name)) {
				HttpSession session = req.getSession();
				session.setAttribute("nameKey", name);
				System.out.println("로그인이 되었습니다.");
				resp.sendRedirect("ch12/sessionLoginOK.jsp");
			}else {
				System.out.println("로그인 되지 않았습니다.");
				resp.sendRedirect("ch12/sessionLogin.jsp");
			}
		}else if(gubun.equals("sessionLogoutProc")) {
			HttpSession session = req.getSession();
		 	session.invalidate();
			System.out.println("로그아웃 되었습니다.");
			resp.sendRedirect("ch12/sessionLogin.jsp");
			
		}
	}
}
