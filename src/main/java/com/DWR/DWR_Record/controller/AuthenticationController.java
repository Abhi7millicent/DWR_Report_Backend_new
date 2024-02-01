package com.DWR.DWR_Record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeeAuthenticationDto;
import com.DWR.DWR_Record.response.AuthenticationResponse;
import com.DWR.DWR_Record.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR")

public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody EmployeeAuthenticationDto employeeAuthenticationDto) {
	    try {
	        // Call a method in your service to handle the login logic
	         AuthenticationResponse authenticationResponse = authenticationService.login(employeeAuthenticationDto.getLoginId(), employeeAuthenticationDto.getPassword());

	        if (authenticationResponse != null) {
	            // If login is successful, you can return a token or any other response
	            return authenticationResponse;
	        } else {
	            // If login fails, you can return an appropriate response
	            return authenticationResponse;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
}
