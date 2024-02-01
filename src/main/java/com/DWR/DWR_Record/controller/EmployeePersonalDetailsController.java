package com.DWR.DWR_Record.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;

import com.DWR.DWR_Record.service.EmployeePersonalDetailService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR")
public class EmployeePersonalDetailsController {
	
	
	@Autowired
	private EmployeePersonalDetailService employeePersonalDetailsService;
	
	
	
	@PostMapping("/employee/details")
	public String AddEmployee(@RequestBody EmployeePersonalDetailsDto employeePersonalDetailsDto) {
		try {
			return employeePersonalDetailsService.addEmployeePersonalDetails(employeePersonalDetailsDto);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}

	
}
