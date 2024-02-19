package com.DWR.DWR_Record.service;

import java.util.List;

import com.DWR.DWR_Record.dto.EmployeeEducationalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeeEducationalDetailsEntity;

public interface EmployeeEducationalDetailsService {

	String addEmployeeEducationalDetails(EmployeeEducationalDetailsDto employeeEducationalDetailsDto);

	List<EmployeeEducationalDetailsEntity> getEducationalDetailsList(String employeeId);


	void updateDeleteFlag(Long id);

	
}
