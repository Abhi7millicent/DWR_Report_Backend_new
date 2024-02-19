package com.DWR.DWR_Record.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.AttandanceManagementDto;
import com.DWR.DWR_Record.entity.AttandanceManagementEntity;
import com.DWR.DWR_Record.service.AttandanceManagementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/attandancemanagement")
public class AttandanceManagementController {
	
	@Autowired
	private AttandanceManagementService attandanceManagementService;
	
	@PostMapping("save/{id}")
	public String addTodaysAttandance(@RequestBody AttandanceManagementDto attandanceManagementDto, @PathVariable("id") String employeeId) {
		try {
			return attandanceManagementService.addTodaysAttandance(attandanceManagementDto,employeeId);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("update/{id}")
	public String updateTodaysAttandance(@RequestBody AttandanceManagementDto attandanceManagementDto, @PathVariable("id") String employeeId) {
		boolean updated = attandanceManagementService.updateTodaysAttandanceByEmployeeId(attandanceManagementDto,employeeId);
		if (updated) {
            return "Attandance updated successfully";
        } else {
            return "Failed to update Attandance. ID not found or invalid data.";
        }
	}

	@GetMapping("data/{id}/{date}")
	public Optional<AttandanceManagementEntity> getAttendanceByID(@PathVariable("id") String employeeId,@PathVariable("date") String date){
		try {
			return attandanceManagementService.getAttendanceByID(employeeId, date);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("attendance/{month}/{year}/{id}")
	public Map<String, String> getAttendanceForMonth(@PathVariable("month") String month,@PathVariable("year") String year,@PathVariable("id") String employeeId){
		try {
			return attandanceManagementService.getAttendanceForMonth(month, year, employeeId);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
}
