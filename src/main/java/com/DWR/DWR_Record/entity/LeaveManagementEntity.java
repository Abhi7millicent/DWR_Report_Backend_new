package com.DWR.DWR_Record.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "leave_management_lm")
public class LeaveManagementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lm")
    private Long id;

    @Column(name = "employeeid_lm")
    private String employeeId;

    @Column(name = "leave_type_lm")
    private String leaveType;

    @Column(name = "description_lm")
    private String description;

    @Column(name = "start_date_lm")
    private String startDate;

    @Column(name = "end_date_lm")
    private String endDate;

    @Column(name = "no_ofdays_lm")
    private String noOfDays;

    @Column(name = "status_lm")
    private String status;

    @Column(name = "deleteflag_lm", columnDefinition = "VARCHAR(3) DEFAULT 'NO'")
    private String deleteflag;

    @Column(name = "balanced_leave_lm")
    private String balancedLeave;
    
    @Column(name = "last_updated_month_year_lm")
    private String lastUpdatedMonthYear;

    

    public LeaveManagementEntity() {
        // Default constructor
    }

    public LeaveManagementEntity(Long id, String employeeId, String leaveType, String description, String startDate,
    		String endDate, String noOfDays, String status, String deleteflag, String balancedLeave) {
        this(); // Calling default constructor
        this.id = id;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDays = noOfDays;
        this.status = status;
        this.deleteflag = deleteflag;
        this.balancedLeave = balancedLeave;
    }

    
    
   

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

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getBalancedLeave() {
		return balancedLeave;
	}

	public void setBalancedLeave(String balancedLeave) {
		this.balancedLeave = balancedLeave;
	}

	public String getLastUpdatedMonthYear() {
		return lastUpdatedMonthYear;
	}

	public void setLastUpdatedMonthYear(String lastUpdatedMonthYear) {
		this.lastUpdatedMonthYear = lastUpdatedMonthYear;
	}

	@Override
	public String toString() {
		return "LeaveManagementEntity [id=" + id + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", noOfDays="
				+ noOfDays + ", status=" + status + ", deleteflag=" + deleteflag + ", balancedLeave=" + balancedLeave
				+ ", lastUpdatedMonthYear=" + lastUpdatedMonthYear + "]";
	}
	
	

   
}
