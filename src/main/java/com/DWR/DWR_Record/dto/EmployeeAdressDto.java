package com.DWR.DWR_Record.dto;

public class EmployeeAdressDto {

	private Long id;
	private Long emp_id;
	private String address1;
	private String address2;
	private String address3;
	private String pincode;
	private String countryCode;
	private String contactNo1;
	private String contactNo2;
	private String type;
	
	public EmployeeAdressDto(Long id, Long emp_id, String address1, String address2, String address3, String pincode,
			String countryCode, String contactNo1, String contactNo2, String type) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.pincode = pincode;
		this.countryCode = countryCode;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.type = type;
	}

	@Override
	public String toString() {
		return "EmployeeAdressDto [id=" + id + ", emp_id=" + emp_id + ", address1=" + address1 + ", address2="
				+ address2 + ", address3=" + address3 + ", pincode=" + pincode + ", countryCode=" + countryCode
				+ ", contactNo1=" + contactNo1 + ", contactNo2=" + contactNo2 + ", type=" + type + "]";
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
