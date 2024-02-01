package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_record_data_erd")
@NamedStoredProcedureQuery(name = "logById", procedureName = "getRecordLogById", parameters = {@StoredProcedureParameter(mode=ParameterMode.IN, name = "userID", type =String.class)})
public class EmployeeRecordDataEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_erd")
	 private Long id;
	 @Column(name = "employee_id_erd")
	 private String employeeId;
	 @Column(name = "date_erd")
	 private String date;
	 @Column(name = "from_time_erd")
	 private String fromTime;
	 @Column(name = "to_time_erd")
	 private String toTime;
	 @Column(name = "project_name_erd")
	 private String projectName;
	 @Column(name = "task_discription_erd")
	 private String taskDiscription;
	 @Column(name = "reported_by_erd")
	 private String reportedBy;
	 @Column(name = "ticket_type_erd")
	 private String ticketType;
	 @Column(name = "status_erd")
	 private String status;
	 @Column(name = "solution_erd")
	 private String solution;
	 
	 
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
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaskDiscription() {
		return taskDiscription;
	}
	public void setTaskDiscription(String taskDiscription) {
		this.taskDiscription = taskDiscription;
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public EmployeeRecordDataEntity(Long id, String employeeId, String date, String fromTime, String toTime,
			String projectName, String taskDiscription, String reportedBy, String ticketType, String status,
			String solution) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.projectName = projectName;
		this.taskDiscription = taskDiscription;
		this.reportedBy = reportedBy;
		this.ticketType = ticketType;
		this.status = status;
		this.solution = solution;
	}
	 
	public EmployeeRecordDataEntity() {
		
	}
	@Override
	public String toString() {
		return "EmployeeRecordDataEntity [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", fromTime="
				+ fromTime + ", toTime=" + toTime + ", projectName=" + projectName + ", taskDiscription="
				+ taskDiscription + ", reportedBy=" + reportedBy + ", ticketType=" + ticketType + ", status=" + status
				+ ", solution=" + solution + "]";
	}
	 
	
}
