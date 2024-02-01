package com.DWR.DWR_Record.service;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.DWR.DWR_Record.entity.EmployeeRecordDataEntity;

public interface EmployeeRecordDataService {

	List<EmployeeRecordDataEntity> getEmployeeRecordDataList(String employeeId, String date);

	List<EmployeeRecordDataEntity> getEmployeeRecordFullDataList(String employeeId);

	Workbook generateExcelWorkbook(List<EmployeeRecordDataEntity> employeeRecords);

	List<EmployeeRecordDataEntity> getEmployeeRecordFullDataListBasedOnRange(String employeeId, String startDate,
			String endDate);

	List<EmployeeRecordDataEntity> readDataFromExcel(InputStream inputStream, String employeeId);

}
