package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_address_ed")
public class EmployeeAdressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_ed")
	 private Long id;
	@Column(name = "employeeid_ed")
	 private String employeeId;
	 @Column(name = "address_type_ed")
	 private String addressType;
	 @Column(name = "addressline_1_ed")
	 private String addressLine1;
	 @Column(name = "addressline_2_ed")
	 private String addressLine2;
	 @Column(name = "country_ed")
	 private String country;
	 @Column(name = "pincode_ed")
	 private String pinCode;
	 @Column(name = "city_ed")
	 private String city;
	 @Column(name = "state_ed")
	 private String state;
	 @Column(name = "contactno_1_ed")
	 private String contactno1;
	 @Column(name = "contactno_2_ed")
	 private String contactno2;
	 
	 
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContactno1() {
		return contactno1;
	}
	public void setContactno1(String contactno1) {
		this.contactno1 = contactno1;
	}
	public String getContactno2() {
		return contactno2;
	}
	public void setContactno2(String contactno2) {
		this.contactno2 = contactno2;
	}
	
	 
	public EmployeeAdressEntity(Long id, String employeeId, String addressType, String addressLine1,
			String addressLine2, String country, String pinCode, String city, String state, String contactno1,
			String contactno2) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.addressType = addressType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.country = country;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.contactno1 = contactno1;
		this.contactno2 = contactno2;
	}
	public EmployeeAdressEntity() {
		
	}
	@Override
	public String toString() {
		return "EmployeeAdressEntity [id=" + id + ", employeeId=" + employeeId + ", addressType=" + addressType
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", country=" + country
				+ ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + ", contactno1=" + contactno1
				+ ", contactno2=" + contactno2 + "]";
	}
	
	
	
	
	 
}
