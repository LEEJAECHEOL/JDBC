package com.cos.test1.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	public static Connection getConnection() {

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/ssar?serverTimezone=Asia/Seoul";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "ssar";
			String password = "1234";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("MySQL COnnect Succes");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MySQL COnnect Fail");
		return null;
	}
}
