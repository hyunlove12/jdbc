package dao.test;

import java.util.ArrayList;

public class EmailListDaoTest {

	public static void main(String[] args) { 
		EmailListVO vo = new EmailListVO();
		vo.setEmail("");
		vo.setFirstName("");
		vo.setLastName("");
		//입력
		//insertTest(vo);
		//출력
		findAll();
	}
	/*
	 * insert 
	 */
	public static void insertTest(EmailListVO vo) {
		//static은 static에서만 호출 가능
		EmailListDao dao1 = new EmailListDao();
		dao1.insert(vo);
	}
	/*
	 * findAll 
	 */
	public static void findAll() {
		ArrayList<EmailListVO> list = new ArrayList<EmailListVO>();
		//static은 static에서만 호출 가능
		EmailListDao dao1 = new EmailListDao();
		list = dao1.findAll();
		for(EmailListVO vo : list) {
			System.out.println(vo);
		}
	}
	
	
}
