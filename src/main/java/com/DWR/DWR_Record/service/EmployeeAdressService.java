package com.DWR.DWR_Record.service;

import java.util.Optional;

import com.DWR.DWR_Record.dto.EmployeeAdressDto;
import com.DWR.DWR_Record.entity.EmployeeAdressEntity;

public interface EmployeeAdressService {
	
	void insertRowInAddressById(String employeeId);

	boolean addAddressDetails(EmployeeAdressDto employeeAdressDto, String employeeId, String addressType);

	Optional<EmployeeAdressEntity> getAddressDetailsById(String employeeId, String addressType);

	
}
