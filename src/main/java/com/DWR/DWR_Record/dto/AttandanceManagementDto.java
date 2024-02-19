package com.DWR.DWR_Record.dto;

public class AttandanceManagementDto {

	private Long id;
	private String employeeId;
	private String date;
	private String startTime;
	private String endTime;
	private String dwrFlag;
	private String deleteflag;
	private String statusflag;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDwrFlag() {
		return dwrFlag;
	}
	public void setDwrFlag(String dwrFlag) {
		this.dwrFlag = dwrFlag;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	public String getStatusflag() {
		return statusflag;
	}
	public void setStatusflag(String statusflag) {
		this.statusflag = statusflag;
	}
	public AttandanceManagementDto(Long id, String employeeId, String date, String startTime, String endTime,
			String dwrFlag, String deleteflag, String statusflag) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dwrFlag = dwrFlag;
		this.deleteflag = deleteflag;
		this.statusflag = statusflag;
	}
	
	public AttandanceManagementDto() {
		
	}
	@Override
	public String toString() {
		return "AttandanceManagementDto [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", dwrFlag=" + dwrFlag + ", deleteflag=" + deleteflag + ", statusflag=" + statusflag + "]";
	}
	
	
}
