package com.DWR.DWR_Record.service;

import java.util.Optional;

import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;

public interface EmployeePersonalDetailsService {

	Optional<EmployeePersonalDetailsEntity> getPersonalDetailsByEmployeeId(String employeeId);

	void insertRowInPersonalDetailsById(String employeeId);

	boolean addEmployeePersonalDetails(EmployeePersonalDetailsDto employeePersonalDetailsDto, String employeeId);

}
