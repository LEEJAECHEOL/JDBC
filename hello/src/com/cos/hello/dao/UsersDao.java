package com.cos.hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.hello.config.DBConn;
import com.cos.hello.model.Users;

public class UsersDao {
	private static UsersDao instance = new UsersDao();
	public static UsersDao getInstance() {
		return instance;
	}
	public UsersDao() {}
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
	public Users login(Users user) {
		Connection conn = DBConn.getInstance();
		StringBuffer sb = new StringBuffer();	// String 전용 컬렉션 (동기화)
		sb.append("SELECT id, username, email FROM users ");
		sb.append("WHERE username = ? AND password = ?");
		String sql = sb.toString();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Users userEntity = Users.builder()
							.id(rs.getInt("id"))
							.username(rs.getString("username"))
							.email(rs.getString("email"))
							.build();
				return userEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Users selectById(int id) {
		Connection conn = DBConn.getInstance();
		StringBuffer sb = new StringBuffer();	// String 전용 컬렉션 (동기화)
		sb.append("SELECT id, username, password, email FROM users ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Users userEntity = Users.builder()
							.id(rs.getInt("id"))
							.username(rs.getString("username"))
							.password(rs.getString("password"))
							.email(rs.getString("email"))
							.build();
				return userEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int updateById(Users user) {
		Connection conn = DBConn.getInstance();
		StringBuffer sb = new StringBuffer();	// String 전용 컬렉션 (동기화)
		sb.append("UPDATE users SET password = ?, email = ? ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int deleteById(int id) {
		Connection conn = DBConn.getInstance();
		StringBuffer sb = new StringBuffer();	// String 전용 컬렉션 (동기화)
		sb.append("DELETE FROM users WHERE id = ?");
		
		String sql = sb.toString();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
