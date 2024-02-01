package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_salary_es")
public class EmployeeSalaryEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_es")
	 private Long id;
	 @Column(name = "emp_id_es")
	 private Long emp_id;
	 @Column(name = "bank_account_name_es")
	 private String bankAccountName;
	 @Column(name = "ifsc_code_es")
	 private String ifscCode;
	 @Column(name = "account_no_es")
	 private String accountNo;
	 @Column(name = "uan_es")
	 private String uan;
	 @Column(name = "epfo_no_es")
	 private String epfoNo;
	 @Column(name = "pan_no_es")
	 private String panNo;
	 @Column(name = "annual_salary_es")
	 private String annualSalary;
	 @Column(name = "monthly_salary_es")
	 private String monthlySalary;
	 
	public EmployeeSalaryEntity(Long id,Long emp_id, String bankAccountName, String ifscCode, String accountNo, String uan,
			String epfoNo, String panNo, String annualSalary, String monthlySalary) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.bankAccountName = bankAccountName;
		this.ifscCode = ifscCode;
		this.accountNo = accountNo;
		this.uan = uan;
		this.epfoNo = epfoNo;
		this.panNo = panNo;
		this.annualSalary = annualSalary;
		this.monthlySalary = monthlySalary;
	}

	public EmployeeSalaryEntity() {
		
	}
	

	@Override
	public String toString() {
		return "EmployeeSalaryEntity [id=" + id + ",emp_id=" + emp_id + ", bankAccountName=" + bankAccountName + ", ifscCode=" + ifscCode
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




