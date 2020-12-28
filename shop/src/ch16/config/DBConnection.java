package ch16.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	public static Connection getInstance() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("mysql/ssar");
			Connection conn = ds.getConnection();
			System.out.println("DB Connect Success");
			return conn;
		} catch (Exception e) {
			System.out.println("DB Connect Fail : " + e.getMessage());
		}
		return null;
		
	}
}
