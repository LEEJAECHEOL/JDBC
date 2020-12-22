package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DBConnection;

public class LoginDao {
	
	public boolean loginRegister(int id, String name) {
		boolean loginCon = false;

		String sql = "SELECT count(*) FROM user WHERE id = ? AND name = ?";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() && rs.getInt(1) > 0) {
				loginCon = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginCon;
	}
	
}
