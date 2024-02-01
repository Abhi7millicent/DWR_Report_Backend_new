package com.DWR.DWR_Record.service;

import java.util.List;
import java.util.Optional;
import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;



public interface EmployeeSalaryService {

	String addEmployeeSalary(EmployeeSalaryDto employeeSalaryDto);

	List<EmployeeSalaryEntity> getEmployeeSalaryList();

	Optional<EmployeeSalaryEntity> getEmployeeSalaryDetailsById(Long id);

	EmployeeSalaryEntity findById(Long id);

	EmployeeSalaryEntity save(EmployeeSalaryEntity existingEmployeeSalary);

}
