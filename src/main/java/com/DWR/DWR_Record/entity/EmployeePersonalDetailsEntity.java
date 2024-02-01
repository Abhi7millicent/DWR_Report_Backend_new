package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_personal_details_epd")
public class EmployeePersonalDetailsEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_epd")
	 private Long id;
	 @Column(name = "emp_id_epd")
	 private Long emp_id;
	 @Column(name = "health_issues_epd")
	 private String healthIssues;
	 @Column(name = "higher_education_epd")
	 private String higherEducation;
	 @Column(name = "institute_name_epd")
	 private String instituteName;
	 @Column(name= "gradute_date")
	 private String graduteDate;
	 @Column(name= "percantage_epd")
	 private String percantage;
	 
	public EmployeePersonalDetailsEntity(Long id, Long emp_id, String healthIssues, String higherEducation,
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
	
	public EmployeePersonalDetailsEntity() {
		
	}
	
	@Override
	public String toString() {
		return "EmployeePersonalDetailsEntity [id=" + id + ", emp_id=" + emp_id + ", healthIssues=" + healthIssues
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




