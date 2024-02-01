package com.DWR.DWR_Record.service;



import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;

import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;



public interface EmployeePersonalDetailService {

	String addEmployeePersonalDetails(EmployeePersonalDetailsDto employeePersonalDetailsDto);

	EmployeePersonalDetailsEntity findById(Long id);


}
