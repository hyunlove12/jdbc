package dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmailListDao {

		
	private Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection conn = null;
		//1. jdbc 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");			
		System.out.println("로드 성공!");
		//2. 연결하기
		String url = "jdbc:mysql://localhost:3306/webdb";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		System.out.println("연결 성공!");	
		return conn;
	}
	
	public int insert(EmailListVO vo) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {				
			conn = this.getConnection();
			//3. statement객체 생성 (statment생성 후 쿼리 실행)
			stmt = conn.createStatement();
			System.out.println("객체 생성 성공!");
			//4. SQL실행
			String sql = "INSERT INTO EMAIL_LIST VALUES(null, '" + vo.getFirstName() + "', '" + vo.getLastName() + "', '" + vo.getEmail() + "') ";
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

	
	
	public ArrayList<EmailListVO> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		ArrayList<EmailListVO> list = new ArrayList<EmailListVO>();
		try {	
			conn = this.getConnection();
			//3. statement객체 생성 (statment생성 후 쿼리 실행)
			stmt = conn.createStatement();
			System.out.println("객체 생성 성공!");
			//4. SQL실행
			String sql = "SELECT * FROM EMAIL_LIST";
			rs = stmt.executeQuery(sql);
			//5. 결과값 출력	
			while(rs.next()) {
				EmailListVO temp = new EmailListVO();
				temp.setEmail(rs.getString("EMAIL"));
				temp.setFirstName(rs.getString("FIRST_NAME"));
				temp.setLastName(rs.getString("LAST_NAME"));
				list.add(temp);
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
		return list;
	}	
}
