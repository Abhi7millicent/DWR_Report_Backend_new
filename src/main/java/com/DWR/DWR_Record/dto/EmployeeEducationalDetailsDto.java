package com.DWR.DWR_Record.dto;

public class EmployeeEducationalDetailsDto {

	private Long id;
	private String employeeId;
	private String degree;
	private String institute;
	private String startDate;
	private String endDate;
	private String percentage;
	
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
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
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public EmployeeEducationalDetailsDto(Long id, String employeeId, String degree, String institute, String startDate,
			String endDate, String percentage) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.degree = degree;
		this.institute = institute;
		this.startDate = startDate;
		this.endDate = endDate;
		this.percentage = percentage;
	}	
	
	public EmployeeEducationalDetailsDto() {
		
	}
	@Override
	public String toString() {
		return "EmployeeEducationalDetailsDto [id=" + id + ", employeeId=" + employeeId + ", degree=" + degree
				+ ", institute=" + institute + ", startDate=" + startDate + ", endDate=" + endDate + ", percentage="
				+ percentage + "]";
	}
	
	
}
