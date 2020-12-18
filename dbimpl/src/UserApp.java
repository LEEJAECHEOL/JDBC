import java.util.Vector;

import dao.UserDao;
import model.User;

public class UserApp {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
//		userDao.insert("홍길동", "0104444444", "부산광역시 부산진구", null);
//		userDao.insert("임꺽정", "0103333333", "서울 특별시", "홍길동");
//		userDao.insert("바보", "0122222222", "서울", "임꺽정");

//		userDao.update(1, "홍길동", "01011111111", "부산", null);
//		userDao.delete(3);
//		userDao.update(1, "홍길동", "01011111111", "부산", "가족");
//		userDao.update(2, "임꺽정", "0103333333", "서울", "친구");
		
		Vector<User> users = (Vector<User>) userDao.selectAll();
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
		}
		Vector<User> userId = (Vector<User>) userDao.selectId(1);
		System.out.println(userId);
		Vector<User> userRelation = (Vector<User>) userDao.selectRelation("홍길동");
		System.out.println(userRelation);
	}

}
