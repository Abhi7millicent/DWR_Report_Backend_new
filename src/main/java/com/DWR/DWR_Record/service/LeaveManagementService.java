package com.DWR.DWR_Record.service;

import java.util.List;

import com.DWR.DWR_Record.dto.LeaveManagementDto;
import com.DWR.DWR_Record.dto.LeaveWithEmployeeDto;
import com.DWR.DWR_Record.entity.LeaveManagementEntity;
import com.DWR.DWR_Record.response.LeaveStatusResponse;

public interface LeaveManagementService {

	String addLeaveByEmployeeId(LeaveManagementDto leaveManagementDto, String employeeId);

	List<LeaveManagementEntity> getListOfLeave(String employeeId);

	String getBlancedLeaveById(String employeeId);

	List<LeaveWithEmployeeDto> getAllLeavesWithEmployeeNames();

	String updateBalancedLeaveForAll();

	LeaveStatusResponse approveLeaveById(Long leaveId);

	LeaveStatusResponse rejectLeaveById(Long leaveId);

	
}
