package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getInstance() {
		Connection conn = null;
		// thin : 순수하게 자바 패키지들만으로 디비와 연결, 주로 사용
		// oci : 특정한 운영체제 내에서만 돌아가는 함수 사용
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SCOTT";
		String password = "TIGER";
		
		// OracleDriver클래스를 메모리에 로드
		try {
			// Class.forName() : 해당 클래스를 메모리로 로드 하는 것
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB Connect Succes");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB Connect Fail");
		return null;
	}
}
