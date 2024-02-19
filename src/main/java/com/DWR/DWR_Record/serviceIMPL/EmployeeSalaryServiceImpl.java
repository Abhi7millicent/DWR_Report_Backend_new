package com.DWR.DWR_Record.serviceIMPL;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;
import com.DWR.DWR_Record.repository.EmployeeSalaryRepository;
import com.DWR.DWR_Record.service.EmployeeSalaryService;


@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {


    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

   
	@Override
	public void insertRowInSalaryById(String employeeId) {
		long empId = Long.parseLong(employeeId);
		try {
			EmployeeSalaryEntity employeeSalaryEntity = new EmployeeSalaryEntity();
			employeeSalaryEntity.setEmpId(empId);
			employeeSalaryRepository.save(employeeSalaryEntity);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        
	    }
	}


	@Override
	public boolean addEmployeeSalaryDetails(String employeeId, EmployeeSalaryDto employeeSalaryDto) {
		Optional<EmployeeSalaryEntity> existingDetails = employeeSalaryRepository.findByEmployeeId(employeeId);
		if (existingDetails.isPresent()) {
			EmployeeSalaryEntity updatedDetails = existingDetails.get();
			
			updatedDetails.setBankAccountName(employeeSalaryDto.getBankAccountName());
			updatedDetails.setIfscCode(employeeSalaryDto.getIfscCode());
			updatedDetails.setAccountNo(employeeSalaryDto.getAccountNo());
			updatedDetails.setUan(employeeSalaryDto.getUan());
			updatedDetails.setEpfoNo(employeeSalaryDto.getEpfoNo());
			updatedDetails.setPanNo(employeeSalaryDto.getPanNo());
			updatedDetails.setAnnualSalary(employeeSalaryDto.getAnnualSalary());
			updatedDetails.setAnnualSalary(employeeSalaryDto.getAnnualSalary());
			updatedDetails.setMonthlySalary(employeeSalaryDto.getMonthlySalary());
			
			employeeSalaryRepository.save(updatedDetails);
			
			return true;
		}else {
            return false; // ID not found
        }
	}


	@Override
	public Optional<EmployeeSalaryEntity> getSalaryDetailsById(Long id) {
		return employeeSalaryRepository.findByEmployeeId(id);
	}

	


}
