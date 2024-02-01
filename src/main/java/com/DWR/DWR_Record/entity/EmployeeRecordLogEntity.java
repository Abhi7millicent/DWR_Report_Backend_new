package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_record_log_eld")
public class EmployeeRecordLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_eld")
	private Long id;
	@Column(name = "employee_id_eld")
	private String employeeId;
	@Column(name = "date_eld")
	private String date;
	@Column(name = "recived_eld")
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
	public EmployeeRecordLogEntity(Long id, String employeeId, String date, String recived) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.recived = recived;
	}
	
	public EmployeeRecordLogEntity() {
		
	}
	@Override
	public String toString() {
		return "EmployeeRecordLogEntity [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", recived="
				+ recived + "]";
	}
	
	
}
