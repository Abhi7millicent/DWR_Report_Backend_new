package com.DWR.DWR_Record.dto;

public class EmployeeAuthenticationDto {

	private String loginId;
	private String password;
	public EmployeeAuthenticationDto(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	public EmployeeAuthenticationDto() {
		
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
		return "EmployeeAuthenticationDto [loginId=" + loginId + ", password=" + password + "]";
	}
	
	
}
