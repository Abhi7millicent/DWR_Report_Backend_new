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
	 @Column(name = "employee_id_epd")
	 private String employeeId;
	 @Column(name = "bloodgroup_epd")
	 private String bloodGroup;
	 @Column(name = "emergency_contact_1_epd")
	 private String emergencyContact1;
	 @Column(name = "emergency_contact_2_epd")
	 private String emergencyContact2;
	 @Column(name = "relation_1_epd")
	 private String relation1;
	 @Column(name = "relation_2_epd")
	 private String relation2;
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
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getEmergencyContact1() {
		return emergencyContact1;
	}
	public void setEmergencyContact1(String emergencyContact1) {
		this.emergencyContact1 = emergencyContact1;
	}
	public String getEmergencyContact2() {
		return emergencyContact2;
	}
	public void setEmergencyContact2(String emergencyContact2) {
		this.emergencyContact2 = emergencyContact2;
	}
	public String getRelation1() {
		return relation1;
	}
	public void setRelation1(String relation1) {
		this.relation1 = relation1;
	}
	public String getRelation2() {
		return relation2;
	}
	public void setRelation2(String relation2) {
		this.relation2 = relation2;
	}
	public EmployeePersonalDetailsEntity(Long id, String employeeId, String bloodGroup, String emergencyContact1,
			String emergencyContact2, String relation1, String relation2) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.bloodGroup = bloodGroup;
		this.emergencyContact1 = emergencyContact1;
		this.emergencyContact2 = emergencyContact2;
		this.relation1 = relation1;
		this.relation2 = relation2;
	}
	 
	public EmployeePersonalDetailsEntity() {
		
	}
	@Override
	public String toString() {
		return "EmployeePersonalDetails [id=" + id + ", employeeId=" + employeeId + ", bloodGroup=" + bloodGroup
				+ ", emergencyContact1=" + emergencyContact1 + ", emergencyContact2=" + emergencyContact2
				+ ", relation1=" + relation1 + ", relation2=" + relation2 + "]";
	}
	
	
	 
}
