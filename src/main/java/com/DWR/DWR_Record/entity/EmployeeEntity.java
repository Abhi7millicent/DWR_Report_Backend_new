package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_master_em")
public class EmployeeEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_em")
	 private Long id;
	 @Column(name = "first_name_em")
	 private String firstName;
	 @Column(name = "middle_name_em")
	 private String middleName;
	 @Column(name = "last_name_em")
	 private String lastName;
	 @Column(name = "email_em")
	 private String email;
	 @Column(name = "date_em")
	 private String date;
	 @Column(name = "reporting_to")
	 private String reporting;
	 @Column(name = "role_em")
	 private String role;
	 @Column(name = "login_em")
	 private String loginId;
	 @Column(name = "password_em")
	 private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReporting() {
		return reporting;
	}
	public void setReporting(String reporting) {
		this.reporting = reporting;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeEntity(Long id, String firstName, String middleName, String lastName, String email, String date,
			String reporting, String role, String loginId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
		this.reporting = reporting;
		this.role = role;
		this.loginId = loginId;
		this.password = password;
	}
	 
	public EmployeeEntity() {
		
	}
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", date=" + date + ", reporting=" + reporting + ", role=" + role
				+ ", loginId=" + loginId + ", password=" + password + "]";
	}
	
	
}


