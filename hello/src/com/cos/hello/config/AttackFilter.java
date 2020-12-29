package com.cos.hello.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class AttackFilter implements Filter {
	class FilterRequest extends HttpServletRequestWrapper{

		public FilterRequest(HttpServletRequest request) {
			super(request);
		}
		public String changeWord(String text) {
			String result = text.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			return result;
		}
		public String getParameter(String parameter){
			String value = super.getParameter(parameter);
			return changeWord(value);
		}
	}
	// 필터는 요청이 들어오기 전만 처리 가능하다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("공격방어 필터 실행");
		// post요청만 받아서 처리!
		// joinProc일 때
		String gubun = request.getParameter("gubun");
		HttpServletRequest req = (HttpServletRequest)request;
		String method = req.getMethod();
		if(method.equals("POST")) {
			// username에 < >들어오는 것을 방어
			// 만약 꺽쇠가 들어오면 전부 &lt; &gt;치환
			// 다시 필터 타게 할 예정
//			String username = request.getParameter("username");
//			username = username.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
			
			chain.doFilter(new FilterRequest((HttpServletRequest)request), response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

}
