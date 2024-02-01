package com.DWR.DWR_Record.dto;



public class EmployeePersonalDetailsDto {

	private Long id;
	private Long emp_id;
	private String healthIssues;
	private String higherEducation;
	private String instituteName;
	private String graduteDate;
	private String percantage;	
	
	
	public EmployeePersonalDetailsDto(Long id, Long emp_id, String healthIssues, String higherEducation,
			String instituteName, String graduteDate, String percantage) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.healthIssues = healthIssues;
		this.higherEducation = higherEducation;
		this.instituteName = instituteName;
		this.graduteDate = graduteDate;
		this.percantage = percantage;
		
	}

	@Override
	public String toString() {
		return "EmployeePersonalDetailsDto [id=" + id + ", emp_id=" + emp_id + ", healthIssues=" + healthIssues
				+ ", higherEducation=" + higherEducation + ", instituteName=" + instituteName + ", graduteDate="
				+ graduteDate + ", percantage=" + percantage + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getHealthIssues() {
		return healthIssues;
	}

	public void setHealthIssues(String healthIssues) {
		this.healthIssues = healthIssues;
	}

	public String getHigherEducation() {
		return higherEducation;
	}

	public void setHigherEducation(String higherEducation) {
		this.higherEducation = higherEducation;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getGraduteDate() {
		return graduteDate;
	}

	public void setGraduteDate(String graduteDate) {
		this.graduteDate = graduteDate;
	}

	public String getPercantage() {
		return percantage;
	}

	public void setPercantage(String percantage) {
		this.percantage = percantage;
	}

	
}
