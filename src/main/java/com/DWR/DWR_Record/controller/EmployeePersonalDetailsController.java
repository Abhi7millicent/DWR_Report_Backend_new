package com.DWR.DWR_Record.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;
import com.DWR.DWR_Record.service.EmployeePersonalDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/employeePersonalDetails")
public class EmployeePersonalDetailsController {

	@Autowired
	private EmployeePersonalDetailsService employeePersonalDetailsService;
	
	@GetMapping("/{id}")
	public Optional<EmployeePersonalDetailsEntity> getPersonalDetailsByEmployeeId(@PathVariable("id") String employeeId){
		try {
			return employeePersonalDetailsService.getPersonalDetailsByEmployeeId(employeeId);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("/update/{id}")
	public String addEmployeePersonalDetails(@RequestBody EmployeePersonalDetailsDto employeePersonalDetailsDto, @PathVariable("id") String employeeId) {
		boolean updated = employeePersonalDetailsService.addEmployeePersonalDetails(employeePersonalDetailsDto, employeeId);
		 if (updated) {
	            return "Educational details updated successfully";
	        } else {
	            return "Failed to update educational details. ID not found or invalid data.";
	        }
	    }
	
}
