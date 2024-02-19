package com.DWR.DWR_Record.dto;

public class EmployeeAdressDto {

	private Long id;
	private String employeeId;
	private String addressType;
	private String addressLine1;
	private String addressLine2;
	private String country;
	private String pinCode;
	private String city;
	private String state;
	private String contactno1;
	private String contactno2;
	
	
	
	
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
	
	
	public EmployeeAdressDto(Long id, String employeeId, String addressType, String addressLine1, String addressLine2,
			String country, String pinCode, String city, String state, String contactno1, String contactno2) {
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
	public EmployeeAdressDto() {
		
	}
	@Override
	public String toString() {
		return "EmployeeAdressDto [id=" + id + ", employeeId=" + employeeId + ", addressType=" + addressType
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", country=" + country
				+ ", pinCode=" + pinCode + ", city=" + city + ", state=" + state + ", contactno1=" + contactno1
				+ ", contactno2=" + contactno2 + "]";
	}
	
	
	
	
	
	
	
}
