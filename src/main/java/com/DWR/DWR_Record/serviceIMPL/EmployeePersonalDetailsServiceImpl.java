package com.DWR.DWR_Record.serviceIMPL;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;
import com.DWR.DWR_Record.repository.EmployeePersonalDetailsRepository;
import com.DWR.DWR_Record.service.EmployeePersonalDetailsService;

@Service
public class EmployeePersonalDetailsServiceImpl implements EmployeePersonalDetailsService{

	@Autowired
	private EmployeePersonalDetailsRepository employeePersonalDetailsRepository;
	
	@Override
	public Optional<EmployeePersonalDetailsEntity> getPersonalDetailsByEmployeeId(String employeeId) {
		
		return employeePersonalDetailsRepository.findByEmployeeId(employeeId);
	}

	@Override
	public void insertRowInPersonalDetailsById(String employeeId) {
		try {
			EmployeePersonalDetailsEntity employeePersonalDetailsEntity = new EmployeePersonalDetailsEntity();
			employeePersonalDetailsEntity.setEmployeeId(employeeId);
			employeePersonalDetailsRepository.save(employeePersonalDetailsEntity);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        
	    }
	}

	@Override
	public boolean addEmployeePersonalDetails(EmployeePersonalDetailsDto employeePersonalDetailsDto,
			String employeeId) {
		Optional<EmployeePersonalDetailsEntity> existingDetails = employeePersonalDetailsRepository.findByEmployeeId(employeeId);
		if (existingDetails.isPresent()) {
			EmployeePersonalDetailsEntity updatedDetails = existingDetails.get();
			updatedDetails.setBloodGroup(employeePersonalDetailsDto.getBloodGroup());
			updatedDetails.setEmergencyContact1(employeePersonalDetailsDto.getEmergencyContact1());
			updatedDetails.setEmergencyContact2(employeePersonalDetailsDto.getEmergencyContact2());
			updatedDetails.setRelation1(employeePersonalDetailsDto.getRelation1());
			updatedDetails.setRelation2(employeePersonalDetailsDto.getRelation2());
			employeePersonalDetailsRepository.save(updatedDetails);
			return true;
		}else {
            return false; // ID not found
        }
	}

}
