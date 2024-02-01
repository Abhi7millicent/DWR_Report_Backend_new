package com.DWR.DWR_Record.service;

import java.util.List;

import com.DWR.DWR_Record.entity.EmployeeRecordLogEntity;

public interface EmployeeRecordService {

	List<EmployeeRecordLogEntity> getEmployeeRecordList(String name);

}
