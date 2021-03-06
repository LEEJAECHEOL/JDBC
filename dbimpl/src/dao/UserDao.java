package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import config.MySQLConnection;
import model.User;

public class UserDao {
	public void insert(String name, String phone, String address, String relation) {
		Connection conn = MySQLConnection.getConnection();
		String query = "INSERT INTO user(name, phone, address, relation) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, relation);
			pstmt.executeUpdate();
			System.out.println("Insert Success");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Fail");
		}
	}
	public void delete(int id) {
		Connection conn = MySQLConnection.getConnection();
		String query = "DELETE FROM user WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Delete Success");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Fail");
		}
	}
	public void update(int id, String name, String phone, String address, String relation) {
		Connection conn = MySQLConnection.getConnection();
		String query = "UPDATE user SET name = ?, phone = ?, address = ?, relation = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, relation);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
			System.out.println("Update Success");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update Fail");
		}
	}
	public List<User> selectAll(){
		List<User> users = new Vector<User>();
		Connection conn = MySQLConnection.getConnection();
		String query = "SELECT id, name, phone, address, relation FROM user";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				users.add(User.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.relation(rs.getString("relation"))
						.build()
						);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> selectId(int id){
		List<User> users = new Vector<User>();
		Connection conn = MySQLConnection.getConnection();
		String query = "SELECT id, name, phone, address, relation FROM user WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				users.add(User.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.relation(rs.getString("relation"))
						.build()
						);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<User> selectRelation(String relation){
		List<User> users = new Vector<User>();
		Connection conn = MySQLConnection.getConnection();
		String query = "SELECT id, name, phone, address, relation FROM user WHERE relation = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, relation);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				users.add(User.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.phone(rs.getString("phone"))
						.address(rs.getString("address"))
						.relation(rs.getString("relation"))
						.build()
						);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
