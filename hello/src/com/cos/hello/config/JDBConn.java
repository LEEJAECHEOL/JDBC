package com.cos.hello.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBConn {
	public static Connection getInstance() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("oracle/scott");
			Connection conn = ds.getConnection();
			System.out.println("JDB Connect Success");
			return conn;
		} catch (Exception e) {
			System.out.println("JDB Connect Fail : " + e.getMessage());
		}
		return null;
	}
}
