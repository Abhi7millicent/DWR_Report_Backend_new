package com.DWR.DWR_Record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeeAdressDto;
import com.DWR.DWR_Record.service.EmployeeAdressService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR")
public class EmployeeAdressController {

	@Autowired
	private EmployeeAdressService employeeAdressService;
	
	@PostMapping("employee/address")
	public String AddEmployeeAdress(@RequestBody EmployeeAdressDto employeeAdressDto) {
		try {			
			return employeeAdressService.addEmployeeAdress(employeeAdressDto);
		} catch (Exception e) {
			e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
		}
	}
}
