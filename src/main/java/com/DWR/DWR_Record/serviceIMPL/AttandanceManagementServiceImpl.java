package com.DWR.DWR_Record.serviceIMPL;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.AttandanceManagementDto;
import com.DWR.DWR_Record.entity.AttandanceManagementEntity;
import com.DWR.DWR_Record.repository.AttandanceManagementRepository;
import com.DWR.DWR_Record.service.AttandanceManagementService;

@Service
public class AttandanceManagementServiceImpl implements AttandanceManagementService {
	
	@Autowired
	private AttandanceManagementRepository attandanceManagementRepository;

	@Override
	public String addTodaysAttandance(AttandanceManagementDto attandanceManagementDto, String employeeId) {

	    // Check if the start time is before 11:00 am
		String statusFlag = Optional.ofNullable(attandanceManagementDto.getStartTime())
	            .map(startTime -> {
	                LocalTime parsedStartTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("h:mm:ss a"));
	                return parsedStartTime.isBefore(LocalTime.of(11, 0)) ? "Present" : "Absent";
	            })
	            .orElse("Absent");

		
		AttandanceManagementEntity attandance = new AttandanceManagementEntity(
				attandanceManagementDto.getId(),
				employeeId,
				attandanceManagementDto.getDate(),
				attandanceManagementDto.getStartTime(),
				"",
				"NO",
				"NO",
				statusFlag
				);
		attandanceManagementRepository.save(attandance);
		return attandance.getStartTime();
	}

	@Override
	public boolean updateTodaysAttandanceByEmployeeId(AttandanceManagementDto attandanceManagementDto,
			String employeeId) {
		return attandanceManagementRepository.findTodayAttandanceByEmployeeId(employeeId, attandanceManagementDto.getDate())
	            .map(existingDetails -> {
	                existingDetails.setEndTime(attandanceManagementDto.getEndTime());
	                String dwrFlag = existingDetails.getDwrFlag();
	                LocalTime endTime = LocalTime.parse(attandanceManagementDto.getEndTime(), DateTimeFormatter.ofPattern("h:mm:ss a"));
	                String statusFlag = (dwrFlag.equalsIgnoreCase("NO") && endTime.isBefore(LocalTime.of(19, 0))) ?
	                        "Halfday" : "Present";
	                existingDetails.setStatusflag(statusFlag);
	                attandanceManagementRepository.save(existingDetails);
	                return true;
	            })
	            .orElse(false);
	}

	@Override
	public Optional<AttandanceManagementEntity> getAttendanceByID(String employeeId, String date) {
		return attandanceManagementRepository.findTodayAttandanceByEmployeeId(employeeId, date);
	}

	@Override
	public Map<String, String> getAttendanceForMonth(String month, String year, String employeeId) {
		List<AttandanceManagementEntity> attendanceList = attandanceManagementRepository.getAttendanceForMonth(month, year, employeeId);
		
		 Map<String, String> result = new HashMap<>();
	        for (AttandanceManagementEntity attendance : attendanceList) {
	            result.put(attendance.getDate(), attendance.getStatusflag());
	        }
		return result;
	}

}
