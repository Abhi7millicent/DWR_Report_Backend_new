package com.DWR.DWR_Record.service;

import java.util.Optional;

import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;



public interface EmployeeSalaryService {



	


	boolean addEmployeeSalaryDetails(String employeeId, EmployeeSalaryDto employeeSalaryDto);


	Optional<EmployeeSalaryEntity> getSalaryDetailsById(Long id);


	void insertRowInSalaryById(String employeeId);

}
