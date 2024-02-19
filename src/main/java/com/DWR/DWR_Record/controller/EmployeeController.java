package com.DWR.DWR_Record.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.EmployeeDto;
import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.service.EmployeeAdressService;
import com.DWR.DWR_Record.service.EmployeePersonalDetailsService;
import com.DWR.DWR_Record.service.EmployeeSalaryService;
import com.DWR.DWR_Record.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeAdressService employeeAdressService;
	
	@Autowired
	private EmployeeSalaryService employeeSalaryService;
	
	@Autowired
	private EmployeePersonalDetailsService employeePersonalDetailsService;
	
//	@Autowired
//    private PasswordEncoder passwordEncoder; // Inject a password encoder bean

	
	@PostMapping("/save")
	public String AddEmployee(@RequestBody EmployeeDto employeeDto) {
		try {
			String employeeId = employeeService.addEmployee(employeeDto);
			employeeSalaryService.insertRowInSalaryById(employeeId);

			employeeAdressService.insertRowInAddressById(employeeId);
			
			employeePersonalDetailsService.insertRowInPersonalDetailsById(employeeId);

			return employeeId;
		} catch (Exception e) {
			e.printStackTrace();
			// Log the exception or return a meaningful response
			return null;
		}
	}
	
	@GetMapping("/list")
	public List<EmployeeEntity> getEmployeeList() {
	    try {
	        return employeeService.getEmployeeList();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@GetMapping("/list/{name}")
	public List<EmployeeEntity> getEmployeeListByName(@PathVariable String name) {
		try {
	        return employeeService.getEmployeeListByName(name);
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}

	@GetMapping("/employee/{id}")
	public Optional<EmployeeEntity> getEmployeeDetailsById(@PathVariable Long id){
		try {
			return employeeService.getEmployeeDetailsById(id);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeEntity updatedEmployee) {
        EmployeeEntity existingEmployee = employeeService.findById(id);
        
        if (existingEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the fields you want to allow updating
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setMiddleName(updatedEmployee.getMiddleName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
//        existingEmployee.setDate(updatedEmployee.getDate());
        existingEmployee.setReporting(updatedEmployee.getReporting());
        existingEmployee.setRole(updatedEmployee.getRole());
//        existingEmployee.setLoginId(updatedEmployee.getLoginId());

        // Check if the password needs to be updated
//        if (!updatedEmployee.getPassword().equals(existingEmployee.getPassword())) {
//            // Encode the new password before updating
//            existingEmployee.setPassword(passwordEncoder.encode(updatedEmployee.getPassword()));
//        }

        EmployeeEntity savedEmployee = employeeService.save(existingEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }
	
	
	@PostMapping("/updateBalancedLeave")
	public String updateBalancedLeave() {
		return employeeService.updateBalancedLeaveForAll();
	}
	
	@GetMapping("balancedleave/{id}")
	public String getBlancedLeaveById(@PathVariable("id") Long employeeId) {
		try {
			return employeeService.getBalancedLeaveById(employeeId);
		} catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
}
