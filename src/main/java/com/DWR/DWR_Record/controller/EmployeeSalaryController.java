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

import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;
import com.DWR.DWR_Record.service.EmployeeSalaryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/employeeSalary")
public class EmployeeSalaryController {
	
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@GetMapping("/{id}")
	public Optional<EmployeeSalaryEntity> getSalaryDetailsById(@PathVariable("id") Long id){
		try {
			return employeeSalaryService.getSalaryDetailsById(id);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("/update/{id}")
	public String addEmployeeSalaryDetails(@RequestBody EmployeeSalaryDto employeeSalaryDto ,@PathVariable("id") String employeeId){
		boolean updated = employeeSalaryService.addEmployeeSalaryDetails(employeeId, employeeSalaryDto);
		 if (updated) {
	            return "Educational details updated successfully";
	        } else {
	            return "Failed to update educational details. ID not found or invalid data.";
	        }
	    }
}
