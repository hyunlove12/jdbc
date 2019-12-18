package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest {

	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			String sql = "SELECT NO, LAST_NAME, FIRST_NAME, EMAIL FROM EMAIL_LIST";			
			rs = stmt.executeQuery(sql);
			System.out.println("쿼리 실행 성공!");
			//5. 결과값 출력
			while(rs.next()) {
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
				//쿼리 날리는 select문의 컬럼 순서대로 출력
				System.out.println(rs.getLong(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println("==============================================");
				System.out.println("no : " + rs.getString("no"));
				System.out.println("first name : " + rs.getString("FIRST_NAME"));
				System.out.println("last name : " + rs.getString("LAST_NAME"));
				System.out.println("email : " + rs.getString("EMAIL"));
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			}
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
	}
}
