package com.cos.hello.config;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.cos.hello.dto.JoinDto;
import com.cos.hello.dto.LoginDto;


public class ParsingFilter implements Filter {
	
	// ex) username -> Username으로 변경
	private String keyToMethodKey(String key) {
		String firstKey = key.substring(0, 1);
		String remainKey = key.substring(1);
		return "set" + firstKey.toUpperCase() + remainKey;
	}
	
	private <T> void setData(T dto, HttpServletRequest req) {
		Enumeration<String> params = req.getParameterNames();
		
		while(params.hasMoreElements()) { // Vector로 부터 생성된 Enumeration의 요소가 있으면 true, 아니면 false 반환
			String key = (String)params.nextElement();	// Enumeration 내의 다음 요소를 반환한다. 
			String methodKey = keyToMethodKey(key);
			System.out.println(methodKey);
			Method[] methods = dto.getClass().getMethods();
			for (Method m : methods) {
				if(m.getName().equals(methodKey)) {
					try {
						m.invoke(dto, req.getParameter(key));	// 해당 set함수 호출
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
			req.setAttribute("dto", dto);
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(req.getParameter("gubun") == null) {
			chain.doFilter(request, response);
			return;
		}
		String gubun = req.getParameter("gubun");
		if(gubun.equals("loginProc")) {
			LoginDto loginDto = new LoginDto();
			setData(loginDto, req);
		}else if(gubun.equals("joinProc")) {
			JoinDto joinDto = new JoinDto();
			setData(joinDto, req);
		}
		chain.doFilter(request, response);
	}

}
