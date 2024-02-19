package com.DWR.DWR_Record.response;

public class LeaveStatusResponse {

	 private String previousStatus;
	 private String numberOfDays;
	 private String employeeId;
	
	 
	 
	public LeaveStatusResponse(String numberOfDays, String employeeId) {
		super();
		this.numberOfDays = numberOfDays;
		this.employeeId = employeeId;
	}

	public LeaveStatusResponse(String previousStatus, String numberOfDays, String employeeId) {
		super();
		this.previousStatus = previousStatus;
		this.numberOfDays = numberOfDays;
		this.employeeId = employeeId;
	}

	public LeaveStatusResponse() {
		
	}

	

	@Override
	public String toString() {
		return "LeaveStatusResponse [previousStatus=" + previousStatus + ", numberOfDays=" + numberOfDays
				+ ", employeeId=" + employeeId + "]";
	}

	public String getPreviousStatus() {
		return previousStatus;
	}

	public void setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
	}

	public String getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
