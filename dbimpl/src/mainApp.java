import java.util.List;

import dao.DeptDao;
import model.Dept;

public class mainApp {
	
	public static void main(String[] args) {
//		추가(9);
//		삭제(1);
//		수정(2,4);
//		Dept dept = 검색(10);
//		System.out.println(dept);
		DeptDao dao = new DeptDao();
		List<Dept> depts = dao.전체검색();
		for(int i = 0; i < depts.size(); i++) {
			System.out.println(depts.get(i));
		}
		
	}

}
