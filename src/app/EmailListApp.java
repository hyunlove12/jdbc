package app;

import java.util.ArrayList;
import java.util.Scanner;

import dao.test.EmailListDao;
import dao.test.EmailListVO;

public class EmailListApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("입력!(성 이름 이메일 // 띄어쓰기로 구분)");
		String input = scan.nextLine();
		String[] tokens = input.split(" ");
		EmailListVO vo = new EmailListVO();
		vo.setFirstName(tokens[0]);
		vo.setLastName(tokens[1]);
		vo.setEmail(tokens[2]);		
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		ArrayList<EmailListVO> list = new ArrayList<EmailListVO>();		
		list = dao.findAll();		
		for(EmailListVO temp : list) {
			System.out.println(temp);
		}
		
	}

}
