package com.DWR.DWR_Record.service;

import java.util.Map;
import java.util.Optional;

import com.DWR.DWR_Record.dto.AttandanceManagementDto;
import com.DWR.DWR_Record.entity.AttandanceManagementEntity;

public interface AttandanceManagementService {

	String addTodaysAttandance(AttandanceManagementDto attandanceManagementDto, String employeeId);

	boolean updateTodaysAttandanceByEmployeeId(AttandanceManagementDto attandanceManagementDto, String employeeId);

	Optional<AttandanceManagementEntity> getAttendanceByID(String employeeId, String date);

	Map<String, String> getAttendanceForMonth(String month, String year, String employeeId);

}
