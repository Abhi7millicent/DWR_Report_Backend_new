package com.DWR.DWR_Record.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.entity.EmployeeRecordLogEntity;
import com.DWR.DWR_Record.repository.EmployeeRecordLogRepository;
import com.DWR.DWR_Record.service.EmployeeRecordService;

@Service
public class EmployeeRecordServiceImpl implements EmployeeRecordService{

	@Autowired
	private EmployeeRecordLogRepository employeeRecordLogRepository;
	
	@Override
	public List<EmployeeRecordLogEntity> getEmployeeRecordList(String name) {
		
		return employeeRecordLogRepository.getEmployeeRecordListByEmployeeId(name);
	}

	

}
