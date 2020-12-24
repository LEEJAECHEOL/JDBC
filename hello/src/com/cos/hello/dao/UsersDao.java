package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.hello.config.DBConn;
import com.cos.hello.model.Users;

public class UsersDao {
	public int insert(Users user) {
		Connection conn = DBConn.getInstance();
		StringBuffer sb = new StringBuffer();	// String 전용 컬렉션 (동기화)
		sb.append("INSERT INTO users(username, password, email) ");
		sb.append("VALUES(?, ?, ?)");
		String sql = sb.toString();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			int result = pstmt.executeUpdate(); // 변경된 행의 개수를 반환
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
