package com.DWR.DWR_Record.dto;


public class LeaveWithEmployeeDto {

	private Long id;
	private String employeeId;
	private String leaveType;
	private String description;
	private String startDate;
	private String endDate;
	private String noOfDays;
	private String status;
	private String deleteflag;
	private String balancedLeave;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public String getBalancedLeave() {
		return balancedLeave;
	}
	public void setBalancedLeave(String balancedLeave) {
		this.balancedLeave = balancedLeave;
	}
	

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public LeaveWithEmployeeDto(Long id, String employeeId, String leaveType, String description, String startDate,
			String endDate, String noOfDays, String status, String deleteflag, String balancedLeave, String name) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.noOfDays = noOfDays;
		this.status = status;
		this.deleteflag = deleteflag;
		this.balancedLeave = balancedLeave;
		this.name = name;
	}
	public LeaveWithEmployeeDto() {
		
	}
	@Override
	public String toString() {
		return "LeaveWithEmployeeDto [id=" + id + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", noOfDays="
				+ noOfDays + ", status=" + status + ", deleteflag=" + deleteflag + ", balancedLeave=" + balancedLeave
				+ ", name=" + name + "]";
	}
	
	
	
}
