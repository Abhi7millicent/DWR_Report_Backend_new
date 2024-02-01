package com.DWR.DWR_Record.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.service.EmployeeSalaryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR")
public class EmployeeSalaryController {
	
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	
	
	@PostMapping("/employee/salary")
	public String AddEmployee(@RequestBody EmployeeSalaryDto employeeSalaryDto) {
		try {
			return employeeSalaryService.addEmployeeSalary(employeeSalaryDto);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}

	
}
