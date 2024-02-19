package com.DWR.DWR_Record.service;

import java.util.List;
import java.util.Optional;

import com.DWR.DWR_Record.dto.EmployeeDto;
import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.response.LeaveStatusResponse;


public interface EmployeeService {

	String addEmployee(EmployeeDto employeeDto);

	List<EmployeeEntity> getEmployeeList();


	List<EmployeeEntity> getEmployeeListByName(String name);

	Optional<EmployeeEntity> getEmployeeDetailsById(Long id);

	EmployeeEntity findById(Long id);

	EmployeeEntity save(EmployeeEntity existingEmployee);

	String updateBalancedLeaveForAll();

	String getBalancedLeaveById(Long employeeId);

	void updateBalancedLeaveById(String balancedLeave, String employeeId);

	void updateBalancedLeaveByIdApprovedAfterRejected(LeaveStatusResponse leaveStatusResponse);

	void updateBalancedLeaveByIdAfterRejection(LeaveStatusResponse leaveStatusResponse);


}
