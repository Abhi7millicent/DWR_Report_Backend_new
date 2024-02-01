package com.DWR.DWR_Record.serviceIMPL;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeePersonalDetailsDto;

import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;

import com.DWR.DWR_Record.repository.EmployeePersonalDetailsRepository;

import com.DWR.DWR_Record.service.EmployeePersonalDetailService;



@Service
public class EmployeePersonalDetailServiceImpl implements EmployeePersonalDetailService {


    @Autowired
    private EmployeePersonalDetailsRepository employeePersonalDetailsRepository;


	@Override
	public String addEmployeePersonalDetails(EmployeePersonalDetailsDto employeePersonalDetailsDto) {
		EmployeePersonalDetailsEntity employeeDetails = new EmployeePersonalDetailsEntity(
				employeePersonalDetailsDto.getId(),
				employeePersonalDetailsDto.getEmp_id(),
				employeePersonalDetailsDto.getHealthIssues(),
				employeePersonalDetailsDto.getHigherEducation(),
				employeePersonalDetailsDto.getInstituteName(),
				employeePersonalDetailsDto.getGraduteDate(),
				employeePersonalDetailsDto.getPercantage()			
        );
        employeePersonalDetailsRepository.save(employeeDetails);
        return employeeDetails.getHigherEducation();
	}

	@Override
	public EmployeePersonalDetailsEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
