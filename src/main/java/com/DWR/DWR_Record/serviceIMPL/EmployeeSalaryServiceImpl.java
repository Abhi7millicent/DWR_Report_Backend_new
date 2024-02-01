package com.DWR.DWR_Record.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeSalaryDto;
import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;
import com.DWR.DWR_Record.repository.EmployeeSalaryRepository;
import com.DWR.DWR_Record.service.EmployeeSalaryService;


@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {


    @Autowired
    private EmployeeSalaryRepository employeeSalaryRepository;

    @Override
    public String addEmployeeSalary(EmployeeSalaryDto employeeSalaryDto) {

        EmployeeSalaryEntity employeeSalary = new EmployeeSalaryEntity(
        		employeeSalaryDto.getId(),
        		employeeSalaryDto.getEmpId(),
        		employeeSalaryDto.getAccountNo(),
        		employeeSalaryDto.getAnnualSalary(),
        		employeeSalaryDto.getBankAccountName(),
        		employeeSalaryDto.getEpfoNo(),
                employeeSalaryDto.getIfscCode(),
                employeeSalaryDto.getPanNo(),
                employeeSalaryDto.getUan(),
                employeeSalaryDto.getMonthlySalary()
        );
        employeeSalaryRepository.save(employeeSalary);
        return employeeSalary.getBankAccountName();
    }

	@Override
	public List<EmployeeSalaryEntity> getEmployeeSalaryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EmployeeSalaryEntity> getEmployeeSalaryDetailsById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public EmployeeSalaryEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeSalaryEntity save(EmployeeSalaryEntity existingEmployeeSalary) {
		// TODO Auto-generated method stub
		return null;
	}


}
