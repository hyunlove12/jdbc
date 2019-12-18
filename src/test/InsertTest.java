package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertTest {

	
	public static void main(String[] args) {
		int result = 0;
		result += insert("김", "구라", "kim@co.kr");
		result += insert("김", "사라", "love@co.kr");
		result += insert("한", "예슬", "han@co.kr");
		System.out.println("결과 값 : " + result);
		/*
		 * boolean reslut = (count == 1 );
		 * 
		 * */
		
	}
	
	public static int insert(String firstName, String lastName, String email) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {	
			//1. jdbc 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");			
			System.out.println("로드 성공!");
			//2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결 성공!");	
			//3. statement객체 생성 (statment생성 후 쿼리 실행)
			stmt = conn.createStatement();
			System.out.println("객체 생성 성공!");
			//4. SQL실행
			String sql = "INSERT INTO EMAIL_LIST VALUES(null, '" + firstName + "', '" + lastName + "', '" + email + "') ";
			result = stmt.executeUpdate(sql);
			//5. 결과값 출력
			System.out.println("결과 : " + result);			
		} catch (ClassNotFoundException e) {
			//throws와 차이!
			System.out.println("드라이버 로딩 실패!" + e);
		} catch (SQLException e) {
			System.out.println("연결오류!" + e);			
		} finally {
			try {
				if( rs != null ) {
					rs.close();					
				}
				if( stmt != null ) {
					stmt.close();					
				}
				if( conn != null ) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
