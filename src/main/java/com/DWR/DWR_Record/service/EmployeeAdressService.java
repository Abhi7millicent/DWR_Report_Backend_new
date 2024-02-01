package com.DWR.DWR_Record.service;

import com.DWR.DWR_Record.dto.EmployeeAdressDto;
import com.DWR.DWR_Record.entity.EmployeeAdressEntity;

public interface EmployeeAdressService {

	String addEmployeeAdress(EmployeeAdressDto employeeAdressDto);
	
	EmployeeAdressEntity findById();
}
