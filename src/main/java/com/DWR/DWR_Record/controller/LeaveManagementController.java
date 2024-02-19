package com.DWR.DWR_Record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.LeaveManagementDto;
import com.DWR.DWR_Record.dto.LeaveWithEmployeeDto;
import com.DWR.DWR_Record.entity.LeaveManagementEntity;
import com.DWR.DWR_Record.response.LeaveStatusResponse;
import com.DWR.DWR_Record.service.EmployeeService;
import com.DWR.DWR_Record.service.LeaveManagementService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/leavemanagement")
public class LeaveManagementController {
	
	@Autowired
	private LeaveManagementService leaveManagementService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("save/{id}")
	public String AddLeaveByEmployeeId(@RequestBody LeaveManagementDto leaveManagementDto, @PathVariable("id") String employeeId) {
		try {
			String statusOfLeave = leaveManagementService.addLeaveByEmployeeId(leaveManagementDto, employeeId);
			employeeService.updateBalancedLeaveById(leaveManagementDto.getBalancedLeave(), employeeId);
			return statusOfLeave;
			
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("list/{id}")
	public List<LeaveManagementEntity> getListOfLeave(@PathVariable("id") String employeeId){
		try {
			return leaveManagementService.getListOfLeave(employeeId);
		}  catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("balancedleave/{id}")
	public String getBlancedLeaveById(@PathVariable("id") String employeeId) {
		try {
			return leaveManagementService.getBlancedLeaveById(employeeId);
		} catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("requestedLeave")
	 public ResponseEntity<List<LeaveWithEmployeeDto>> getAllLeavesWithEmployeeNames(){
		try {
			List<LeaveWithEmployeeDto> leaveDetails = leaveManagementService.getAllLeavesWithEmployeeNames();
			return ResponseEntity.ok(leaveDetails);
		} catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PostMapping("/approve/{leaveId}")
	public String approveLeaveById(@PathVariable("leaveId") Long leaveId) {
		try {
		    LeaveStatusResponse leaveStatusResponse = leaveManagementService.approveLeaveById(leaveId);
		    if ("Rejected".equals(leaveStatusResponse.getPreviousStatus())) {
		        employeeService.updateBalancedLeaveByIdApprovedAfterRejected(leaveStatusResponse);
		    }
		    return "Leave has been approved.";
		} catch (Exception e) {
		    return "Failed to process leave approval: " + e.getMessage();
		}
	}
	
	@PostMapping("/reject/{leaveId}")
	public String rejectLeaveById(@PathVariable("leaveId") Long leaveId) {
		try {
			LeaveStatusResponse leaveStatusResponse = leaveManagementService.rejectLeaveById(leaveId);
			employeeService.updateBalancedLeaveByIdAfterRejection(leaveStatusResponse);
			return "Leave has been rejected.";
		} catch (Exception e) {
			return "Failed to process leave rejection: " + e.getMessage();
		}
	}
	
	
//	@PostMapping("/updateBalancedLeave")
//	public String updateBalancedLeave() {
//		return leaveManagementService.updateBalancedLeaveForAll();
//	}
	
}
