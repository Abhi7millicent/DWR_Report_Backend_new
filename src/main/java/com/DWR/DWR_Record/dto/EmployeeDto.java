package com.DWR.DWR_Record.dto;

public class EmployeeDto {

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String date;
	private String reporting;
	private String role;
	private String loginId;
	private String password;
	
	public EmployeeDto(Long id, String firstName, String middleName, String lastName, String email, String date,
			String reporting, String role, String loginId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.reporting = reporting;
		this.role = role;
		this.loginId = loginId;
		this.password = password;
	}
	
	public EmployeeDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReporting() {
		return reporting;
	}

	public void setReporting(String reporting) {
		this.reporting = reporting;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", date=" + date + ", reporting=" + reporting + ", role=" + role
				+ ", loginId=" + loginId + ", password=" + password + "]";
	}
	
	
}
