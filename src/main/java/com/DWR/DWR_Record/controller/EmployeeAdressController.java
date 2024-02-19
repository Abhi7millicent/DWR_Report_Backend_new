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

import com.DWR.DWR_Record.dto.EmployeeAdressDto;
import com.DWR.DWR_Record.entity.EmployeeAdressEntity;
import com.DWR.DWR_Record.service.EmployeeAdressService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/addressDetails")
public class EmployeeAdressController {

	@Autowired
	private EmployeeAdressService employeeAdressService;
	
	@GetMapping("/{addressType}/{id}")
	public Optional<EmployeeAdressEntity> getAddressDetailsById(@PathVariable("id") String employeeId, @PathVariable("addressType") String addressType){
		try {
		return employeeAdressService.getAddressDetailsById(employeeId, addressType);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("/update/{addressType}/{id}")
	public String AddAddressDetails(@RequestBody EmployeeAdressDto employeeAdressDto, @PathVariable("id") String employeeId, @PathVariable("addressType") String addressType) {
		boolean updated = employeeAdressService.addAddressDetails(employeeAdressDto, employeeId, addressType);
		if (updated) {
            return "Educational details updated successfully";
        } else {
            return "Failed to update educational details. ID not found or invalid data.";
        }
    }
	
}
