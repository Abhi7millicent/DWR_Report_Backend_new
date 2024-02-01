package com.DWR.DWR_Record.serviceIMPL;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeDto;
import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.repository.EmployeeRepository;
import com.DWR.DWR_Record.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        LocalDate currentDate = LocalDate.now();

        EmployeeEntity employee = new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getMiddleName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                currentDate.toString(),
                employeeDto.getReporting(),
                employeeDto.getRole(),
                employeeDto.getLoginId(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getFirstName();
    }

    @Override
    public List<EmployeeEntity> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeEntity> getEmployeeListByName(String name) {
        return employeeRepository.getEmployeeByFirstName(name);
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeDetailsById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

}
