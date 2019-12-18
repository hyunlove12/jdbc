package dao.test;

import java.io.Serializable;

public class EmailListVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2126736546957182123L;
	
	private Long no;
	private String Email = "";
	private String firstName = "";
	private String lastName = "";
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {		
		return lastName + "," +  firstName + "," + Email;
	}
	
}
