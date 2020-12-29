package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {

	
	static <T> void myReflect(T dto) {
		Method[] methods = dto.getClass().getMethods();
		// 변수
		Field[] fs = dto.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);	// private 멤버에 접근 가능 기법
			try {
				if(f.getName().equals("password")) {
					f.set(dto, "5678");
				}
				Object o = f.get(dto);
				
				System.out.println(o);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		
		JoinDto joinDto = new JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEmail("ssar@nate.com");
		
		myReflect(loginDto);
		myReflect(joinDto);
		
		
	}
}
