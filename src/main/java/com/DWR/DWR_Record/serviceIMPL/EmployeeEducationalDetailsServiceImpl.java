package com.DWR.DWR_Record.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeEducationalDetailsDto;
import com.DWR.DWR_Record.entity.EmployeeEducationalDetailsEntity;
import com.DWR.DWR_Record.repository.EmployeeEducationalDetailsRepository;
import com.DWR.DWR_Record.service.EmployeeEducationalDetailsService;

@Service
public class EmployeeEducationalDetailsServiceImpl implements EmployeeEducationalDetailsService{
	
	@Autowired
	private EmployeeEducationalDetailsRepository employeeEducationalDetailsRepository;

	@Override
	public String addEmployeeEducationalDetails(EmployeeEducationalDetailsDto employeeEducationalDetailsDto) {
		EmployeeEducationalDetailsEntity educationalDetails = new EmployeeEducationalDetailsEntity(
				employeeEducationalDetailsDto.getId(),
				employeeEducationalDetailsDto.getEmployeeId(),
				employeeEducationalDetailsDto.getDegree(),
				employeeEducationalDetailsDto.getInstitute(),
				employeeEducationalDetailsDto.getStartDate(),
				employeeEducationalDetailsDto.getEndDate(),
				employeeEducationalDetailsDto.getPercentage(),
				"NO"
				);
		employeeEducationalDetailsRepository.save(educationalDetails);
		return educationalDetails.getDegree();
	}

	@Override
	public List<EmployeeEducationalDetailsEntity> getEducationalDetailsList(String employeeId) {
		return employeeEducationalDetailsRepository.getEducationalDetailListById(employeeId);
	}

	@Override
	public void updateDeleteFlag(Long id) {
		EmployeeEducationalDetailsEntity entity = employeeEducationalDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee educational details not found for id: " + id));
        entity.setDeleteFlag("YES");
        employeeEducationalDetailsRepository.save(entity);
	}

	
	

}
