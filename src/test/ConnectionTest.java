package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionTest {

	
	public static void main(String[] args) {
		Connection conn = null;
		try {	
			//1. jdbc 드라이버 로드
			Class.forName("com.mysql.jdbc.Driver");			
			System.out.println("로드성공!");
			//2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공!");			
		} catch (ClassNotFoundException e) {
			//throws와 차이!
			System.out.println("드라이버 로딩 실패!" + e);
			System.out.println("------------------------------------------------------------------");
			e.printStackTrace();
			System.out.println("------------------------------------------------------------------");
		} catch (SQLException e) {
			System.out.println("연결오류!" + e);
			System.out.println("------------------------------------------------------------------");
			e.printStackTrace();
			System.out.println("------------------------------------------------------------------");
		} finally {
			try {
				if( conn != null ) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
