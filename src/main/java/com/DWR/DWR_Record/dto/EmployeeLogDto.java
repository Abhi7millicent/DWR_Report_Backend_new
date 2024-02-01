package com.DWR.DWR_Record.dto;

public class EmployeeLogDto {

	private Long id;
	private String employeeId;
	private String date;
	private String recived;
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
	public String getRecived() {
		return recived;
	}
	public void setRecived(String recived) {
		this.recived = recived;
	}
	public EmployeeLogDto(Long id, String employeeId, String date, String recived) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.recived = recived;
	}
	public EmployeeLogDto() {
	}
	@Override
	public String toString() {
		return "EmployeeLogDto [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", recived=" + recived
				+ "]";
	}
	
	
}
