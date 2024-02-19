package com.DWR.DWR_Record.serviceIMPL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.EmployeeDto;
import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.repository.EmployeeRepository;
import com.DWR.DWR_Record.response.LeaveStatusResponse;
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
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
	    String currentMonth = currentDate.format(formatter);
        EmployeeEntity employee = new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getMiddleName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                currentDate.toString(),
                "0",
                currentMonth,
                employeeDto.getReporting(),
                employeeDto.getRole(),
                employeeDto.getLoginId(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getId().toString();
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

    @Override
    public String updateBalancedLeaveForAll() {
        LocalDate currentDate = LocalDate.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String currentMonth = currentDate.format(formatter);
        
        boolean leaveAlreadyAdded = employeeRepository.findAll().stream()
            .anyMatch(entity -> currentMonth.equals(entity.getLastUpdatedMonthYear()));
        
        if (leaveAlreadyAdded) {
            return "Leave already added for the current month.";
        } else {
            employeeRepository.findAll().forEach(entity -> {
                int balancedLeave = 0;
                String balancedLeaveStr = entity.getBalancedLeave();
                if (balancedLeaveStr == null || balancedLeaveStr.equals("null")) {
                    balancedLeave = 0;
                } else {
                    balancedLeave = Integer.parseInt(balancedLeaveStr);
                }
                
                int newBalancedLeave = balancedLeave + 2;
                entity.setBalancedLeave(String.valueOf(newBalancedLeave));
                entity.setLastUpdatedMonthYear(currentMonth);
                employeeRepository.save(entity);
            });
            return "Leave updated successfully for all entities.";
        }
    }

	@Override
	public String getBalancedLeaveById(Long employeeId) {
		return employeeRepository.getBlancedLeaveById(employeeId);
	}

	@Override
	public void updateBalancedLeaveById(String balancedLeave, String employeeId) {
		long empId = Long.parseLong(employeeId);
		
		employeeRepository.findById(empId).ifPresent(employee -> {
			employee.setBalancedLeave(balancedLeave);
			employeeRepository.save(employee);
		});
	}

	@Override
	public void updateBalancedLeaveByIdApprovedAfterRejected(LeaveStatusResponse leaveStatusResponse) {
		long empId = Long.parseLong(leaveStatusResponse.getEmployeeId());
		
		employeeRepository.findById(empId).ifPresent(employee -> {
			employee.setBalancedLeave(String.valueOf(Integer.parseInt(employee.getBalancedLeave()) - Integer.parseInt(leaveStatusResponse.getNumberOfDays())));
			employeeRepository.save(employee);
		});
	}

	@Override
	public void updateBalancedLeaveByIdAfterRejection(LeaveStatusResponse leaveStatusResponse) {
		long empId = Long.parseLong(leaveStatusResponse.getEmployeeId());
		
		employeeRepository.findById(empId).ifPresent(employee -> {
			employee.setBalancedLeave(String.valueOf(Integer.parseInt(employee.getBalancedLeave()) + Integer.parseInt(leaveStatusResponse.getNumberOfDays())));
			employeeRepository.save(employee);
		});
	}


}
