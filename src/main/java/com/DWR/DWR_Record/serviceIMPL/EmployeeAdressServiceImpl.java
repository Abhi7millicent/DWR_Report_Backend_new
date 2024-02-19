package com.DWR.DWR_Record.serviceIMPL;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeAdressDto;
import com.DWR.DWR_Record.entity.EmployeeAdressEntity;
import com.DWR.DWR_Record.repository.EmployeeAddressRepository;
import com.DWR.DWR_Record.service.EmployeeAdressService;

@Service
public class EmployeeAdressServiceImpl implements EmployeeAdressService {
	
	@Autowired
	EmployeeAddressRepository employeeAdressRepository;

	

	@Override
	public void insertRowInAddressById(String employeeId) {
		String addressType1 = "Permanent";
		try {
			EmployeeAdressEntity employeeAdressEntity = new EmployeeAdressEntity();
			employeeAdressEntity.setEmployeeId(employeeId);
			employeeAdressEntity.setAddressType(addressType1);
			employeeAdressRepository.save(employeeAdressEntity);
			if(employeeAdressEntity.getAddressType().equals("Permanent")) {
				String addressType2 = "Temporary";
				EmployeeAdressEntity employeeAdressEntity1 = new EmployeeAdressEntity();
				employeeAdressEntity1.setEmployeeId(employeeId);
				employeeAdressEntity1.setAddressType(addressType2);
				employeeAdressRepository.save(employeeAdressEntity1);
			}
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	    }
		
	}

	@Override
	public boolean addAddressDetails(EmployeeAdressDto employeeAdressDto, String employeeId, String addressType) {
		Optional<EmployeeAdressEntity> existingDetails = employeeAdressRepository.findByEmployeeIdAndAddressType(employeeId, addressType);
		if(existingDetails.isPresent()) {
			EmployeeAdressEntity updatedDetails = existingDetails.get();
			
			updatedDetails.setAddressLine1(employeeAdressDto.getAddressLine1());
			updatedDetails.setAddressLine2(employeeAdressDto.getAddressLine2());
			updatedDetails.setCountry(employeeAdressDto.getCountry());
			updatedDetails.setPinCode(employeeAdressDto.getPinCode());
			updatedDetails.setCity(employeeAdressDto.getCity());
			updatedDetails.setState(employeeAdressDto.getState());
			updatedDetails.setContactno1(employeeAdressDto.getContactno1());
			updatedDetails.setContactno2(employeeAdressDto.getContactno2());
			
			employeeAdressRepository.save(updatedDetails);
			
			return true;
		}else {
		return false;
		}
	}

	@Override
	public Optional<EmployeeAdressEntity> getAddressDetailsById(String employeeId, String addressType) {
		return employeeAdressRepository.findByEmployeeIdAndAddressType(employeeId, addressType);
	}

	

	

}
