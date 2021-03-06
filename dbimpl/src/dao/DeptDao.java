package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import config.DBConnection;
import model.Dept;

// Data Access Object (데이터에 접근하게 해주는 객체) -> 재사용
// application -> DAO -> DB
// 데이터베이스는 비동기 처리를 못한다.
// 동시접속가능
public class DeptDao {

	public void 추가(int id) {
		String sql = "INSERT INTO test1(id) VALUES(?)";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);	// 인젝션 공격을 막아 준다.
			int result = pstmt.executeUpdate();	// 변경된 row count를 리턴, -1은 오류시에 리턴된다.
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void 삭제(int id) {
		String sql = "DELETE FROM test1 WHERE id = ?";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);	// 인젝션 공격을 막아 준다.
			int result = pstmt.executeUpdate();	// 변경된 row count를 리턴, -1은 오류시에 리턴된다.
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void 수정(int id, int changeId) {
		String sql = "UPDATE test1 SET id = ? WHERE id = ?";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, changeId);	// 인젝션 공격을 막아 준다.
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();	// 변경된 row count를 리턴, -1은 오류시에 리턴된다.
			System.out.println("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Dept 검색(int deptno) {
		String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);	// 인젝션 공격을 막아 준다.
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Dept dept = Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
				System.out.println(dept);
				return dept;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Dept> 전체검색() {
		List<Dept> depts = new Vector<>();
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection conn = DBConnection.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				depts.add(
					Dept.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build()
						);
			}
			return depts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
