package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attandance_management_am")
public class AttandanceManagementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_am")
	private Long id;
	@Column(name = "employeeid_am")
	private String employeeId;
	@Column(name = "date_am")
	private String date;
	@Column(name = "start_time_am")
	private String startTime;
	@Column(name = "end_time_am")
	private String endTime;
	@Column(name = "dwrflag_am", columnDefinition = "VARCHAR(3) DEFAULT 'NO'")
	private String dwrFlag;
	@Column(name = "deleteflag_am", columnDefinition = "VARCHAR(3) DEFAULT 'NO'")
	private String deleteflag;
	@Column(name = "statusflag_am")
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
	public AttandanceManagementEntity(Long id, String employeeId, String date, String startTime, String endTime,
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
	
	public AttandanceManagementEntity() {
		
	}
	@Override
	public String toString() {
		return "AttandanceManagementEntity [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", dwrFlag=" + dwrFlag + ", deleteflag=" + deleteflag + ", statusflag=" + statusflag + "]";
	}
	
	
}
