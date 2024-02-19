package com.DWR.DWR_Record.serviceIMPL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.LeaveManagementDto;
import com.DWR.DWR_Record.dto.LeaveWithEmployeeDto;
import com.DWR.DWR_Record.entity.EmployeeEntity;
import com.DWR.DWR_Record.entity.LeaveManagementEntity;
import com.DWR.DWR_Record.repository.EmployeeRepository;
import com.DWR.DWR_Record.repository.LeaveManagementRepository;
import com.DWR.DWR_Record.response.LeaveStatusResponse;
import com.DWR.DWR_Record.service.LeaveManagementService;

@Service
public class LeaveManagementServiceImpl implements LeaveManagementService{

	@Autowired
	private LeaveManagementRepository leaveManagementRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String addLeaveByEmployeeId(LeaveManagementDto leaveManagementDto, String employeeId) {
		LeaveManagementEntity leave = new LeaveManagementEntity(
				leaveManagementDto.getId(),
				employeeId,
				leaveManagementDto.getLeaveType(),
				leaveManagementDto.getDescription(),
				leaveManagementDto.getStartDate(),
				leaveManagementDto.getEndDate(),
				leaveManagementDto.getNoOfDays(),
				"Pending",
				"NO",
				leaveManagementDto.getBalancedLeave()
				);
		leaveManagementRepository.save(leave);
		return leave.getStatus();
	}

	@Override
	public List<LeaveManagementEntity> getListOfLeave(String employeeId) {
		return leaveManagementRepository.getListOfLeaveByEmployeeId(employeeId);
	}

	@Override
	public String getBlancedLeaveById(String employeeId) {
		return leaveManagementRepository.getBlancedLeaveById(employeeId);
	}

	@Override
	public List<LeaveWithEmployeeDto> getAllLeavesWithEmployeeNames() {
		List<LeaveManagementEntity> leaveEntities = leaveManagementRepository.findAll();
        List<LeaveWithEmployeeDto> leaveWithEmployeeDetails = new ArrayList<>();
        for (LeaveManagementEntity leaveEntity : leaveEntities) {
        	Long employeeId = Long.parseLong(leaveEntity.getEmployeeId());
            EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
            if (employeeEntity != null) {
            	LeaveWithEmployeeDto dto = new LeaveWithEmployeeDto();
                dto.setId(leaveEntity.getId());
                dto.setEmployeeId(leaveEntity.getEmployeeId());
                dto.setLeaveType(leaveEntity.getLeaveType());
                dto.setDescription(leaveEntity.getDescription());
                dto.setStartDate(leaveEntity.getStartDate());
                dto.setEndDate(leaveEntity.getEndDate());
                dto.setNoOfDays(leaveEntity.getNoOfDays());
                dto.setStatus(leaveEntity.getStatus());
                dto.setDeleteflag(leaveEntity.getDeleteflag());
                dto.setBalancedLeave(leaveEntity.getBalancedLeave());
                dto.setName(employeeEntity.getFirstName() + " " + employeeEntity.getLastName());
                leaveWithEmployeeDetails.add(dto);
            }
        }
        return leaveWithEmployeeDetails;
	}

	@Override
	public String updateBalancedLeaveForAll() {
	    LocalDate currentDate = LocalDate.now();
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
	    String currentMonth = currentDate.format(formatter);
	    
	    boolean leaveAlreadyAdded = leaveManagementRepository.findAll().stream()
	        .anyMatch(entity -> currentMonth.equals(entity.getLastUpdatedMonthYear()));
	    
	    if (leaveAlreadyAdded) {
	        return "Leave already added for the current month.";
	    } else {
	        leaveManagementRepository.findAll().forEach(entity -> {
	            int balancedLeave = Integer.parseInt(entity.getBalancedLeave());
	            int newBalancedLeave = balancedLeave + 2;
	            entity.setBalancedLeave(String.valueOf(newBalancedLeave));
	            entity.setLastUpdatedMonthYear(currentMonth);
	            leaveManagementRepository.save(entity);
	        });
	        return "Leave updated successfully for all entities.";
	    }
	}

	@Override
	public LeaveStatusResponse approveLeaveById(Long leaveId) {
	    AtomicReference<String> previousStatus = new AtomicReference<>(null); // Using AtomicReference to store previousStatus
	    StringBuilder numberOfDays = new StringBuilder();
	    StringBuilder employeeId = new StringBuilder();
	    leaveManagementRepository.findById(leaveId).ifPresent(leave -> {
	        previousStatus.set(leave.getStatus()); // Store previous status
	        numberOfDays.append(leave.getNoOfDays());
	        employeeId.append(leave.getEmployeeId());
	        leave.setStatus("Approved");
	        leaveManagementRepository.save(leave);
	    });

	    return new LeaveStatusResponse(previousStatus.get(), numberOfDays.toString(), employeeId.toString());
	}

	@Override
	public LeaveStatusResponse rejectLeaveById(Long leaveId) {
		StringBuilder numberOfDays = new StringBuilder();
	    StringBuilder employeeId = new StringBuilder();
		leaveManagementRepository.findById(leaveId).ifPresent(leave -> {
			numberOfDays.append(leave.getNoOfDays());
			employeeId.append(leave.getEmployeeId());
			leave.setStatus("Rejected");
			leaveManagementRepository.save(leave);
		});
		return new LeaveStatusResponse(numberOfDays.toString(), employeeId.toString());
	}


}
