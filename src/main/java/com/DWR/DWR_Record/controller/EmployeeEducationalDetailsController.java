package com.DWR.DWR_Record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.DWR.DWR_Record.dto.EmployeeEducationalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeeEducationalDetailsEntity;
import com.DWR.DWR_Record.service.EmployeeEducationalDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/educationalDetails")
public class EmployeeEducationalDetailsController {

	@Autowired
	private EmployeeEducationalDetailsService employeeEducationalDetailsService;
	
	@PostMapping("/save")
	public String AddEmployeeEducationalDetails(@RequestBody EmployeeEducationalDetailsDto employeeEducationalDetailsDto) {
		try {
		return employeeEducationalDetailsService.addEmployeeEducationalDetails(employeeEducationalDetailsDto);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("/list/{id}")
	public List<EmployeeEducationalDetailsEntity> getEducationalDetailsList(@PathVariable("id") String employeeId) {
		try {
			return employeeEducationalDetailsService.getEducationalDetailsList(employeeId);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<String> updateDeleteFlag(@PathVariable Long id) {
		employeeEducationalDetailsService.updateDeleteFlag(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete flag updated successfully");
    }

}
