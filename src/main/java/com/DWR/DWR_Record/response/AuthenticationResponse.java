package com.DWR.DWR_Record.response;

public class AuthenticationResponse {

	private String message;
	private String token;
	Boolean status;
	private String role;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public AuthenticationResponse(String message, String token, Boolean status, String role) {
		super();
		this.message = message;
		this.token = token;
		this.status = status;
		this.role = role;
	}
	public AuthenticationResponse() {
		
	}
	@Override
	public String toString() {
		return "AuthenticationResponse [message=" + message + ", token=" + token + ", status=" + status + ", role="
				+ role + "]";
	}
	
	
	
	
}
