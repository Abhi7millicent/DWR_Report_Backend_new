package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_educational_details_eed")
public class EmployeeEducationalDetailsEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_eed")
 private Long id;
 @Column(name = "emp_id_eed")
 private String employeeId;
 @Column(name = "degree_eed")
 private String degree;
 @Column(name = "institute_eed")
 private String institute;
 @Column(name = "start_date_eed")
 private String startDate;
 @Column(name = "end_date_eed")
 private String endDate;
 @Column(name = "percentage_eed")
 private String percentage;
 @Column(name = "deleteflag_eed", columnDefinition = "VARCHAR(3) DEFAULT 'No'")
 private String deleteFlag;
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
public String getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(String deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public EmployeeEducationalDetailsEntity(Long id, String employeeId, String degree, String institute, String startDate,
		String endDate, String percentage, String deleteFlag) {
	super();
	this.id = id;
	this.employeeId = employeeId;
	this.degree = degree;
	this.institute = institute;
	this.startDate = startDate;
	this.endDate = endDate;
	this.percentage = percentage;
	this.deleteFlag = deleteFlag;
}
 
public EmployeeEducationalDetailsEntity() {
	
}
@Override
public String toString() {
	return "EmployeeEducationalDetailsEntity [id=" + id + ", employeeId=" + employeeId + ", degree=" + degree
			+ ", institute=" + institute + ", startDate=" + startDate + ", endDate=" + endDate + ", percentage="
			+ percentage + ", deleteFlag=" + deleteFlag + "]";
}


}
