package com.DWR.DWR_Record.dto;

public class EmployeeSalaryDto {


	
	private Long id;
	private Long emp_id;
	private String bankAccountName;
	private String ifscCode;
	private String accountNo;
	private String uan;
	private String epfoNo;
	private String panNo;
	private String annualSalary;
	private String monthlySalary;
	
	public EmployeeSalaryDto(Long id, Long emp_id,String bankAccountName, String ifscCode, String accountNo, String uan,
			String epfoNo, String panNo, String annualSalary, String monthlySalary) {
		super();
		this.id = id;
		this.emp_id=emp_id;
		this.bankAccountName = bankAccountName;
		this.ifscCode = ifscCode;
		this.accountNo = accountNo;
		this.uan = uan;
		this.epfoNo = epfoNo;
		this.panNo = panNo;
		this.annualSalary = annualSalary;
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String toString() {
		return "EmployeSalaryDto [id=" + id + ", emp_id="+ emp_id +", bankAccountName=" + bankAccountName + ", ifscCode=" + ifscCode
				+ ", accountNo=" + accountNo + ", uan=" + uan + ", epfoNo=" + epfoNo + ", panNo=" + panNo
				+ ", annualSalary=" + annualSalary + ", monthlySalary=" + monthlySalary + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getEmpId() {
		return emp_id;
	}

	public void setEmpId(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUan() {
		return uan;
	}

	public void setUan(String uan) {
		this.uan = uan;
	}

	public String getEpfoNo() {
		return epfoNo;
	}

	public void setEpfoNo(String epfoNo) {
		this.epfoNo = epfoNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	

	
}
