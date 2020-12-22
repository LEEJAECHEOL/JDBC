package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/address?serverTimezone=Asia/Seoul";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "wocjf476125");
			System.out.println("MySQL COnnect Succes");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MySQL COnnect Fail");
		return null;
	}
}
