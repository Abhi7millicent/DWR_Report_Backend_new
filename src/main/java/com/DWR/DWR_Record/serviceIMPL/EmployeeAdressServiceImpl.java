package com.DWR.DWR_Record.serviceIMPL;

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
	public String addEmployeeAdress(EmployeeAdressDto employeeAdressDto) {
		EmployeeAdressEntity employeeAdress = new EmployeeAdressEntity(
		employeeAdressDto.getId(),
		employeeAdressDto.getEmp_id(),
		employeeAdressDto.getAddress1(),
		employeeAdressDto.getAddress2(),
		employeeAdressDto.getPincode(),
		employeeAdressDto.getAddress3(),
		employeeAdressDto.getCountryCode(),
		employeeAdressDto.getContactNo1(),
		employeeAdressDto.getContactNo2(),
		employeeAdressDto.getType()
		);
		employeeAdressRepository.save(employeeAdress);		
		return employeeAdress.getType();
	}

	@Override
	public EmployeeAdressEntity findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
