package com.DWR.DWR_Record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dao.EmployeeRecordDataDao;
import com.DWR.DWR_Record.dto.EmployeeLogDto;
//import com.DWR.DWR_Record.entity.EmployeeRecordLogEntity;
//import com.DWR.DWR_Record.service.EmployeeRecordDataService;
//import com.DWR.DWR_Record.service.EmployeeRecordService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/employeeRecord")
public class EmployeeRecordController {
	
//	@Autowired
//	private EmployeeRecordService employeeRecordService;
	
//	@Autowired
//	private EmployeeRecordDataService employeeRecordDataService;
	
	@Autowired
	private EmployeeRecordDataDao employeeRecordDataDao;
//	@GetMapping("/list/{empId}")
//	public List<EmployeeRecordLogEntity> getEmployeeRecordList(@PathVariable String empId) {
//	    try {
//	        return employeeRecordService.getEmployeeRecordList(empId);
////	        return employeeRecordDataService.getEmployeeRecordFullDataList(empId);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        // Log the exception or return a meaningful response
//	        return null;
//	    }
//	}
	
	@GetMapping("/list/{empId}")
	public  List<EmployeeLogDto> getUserLogById(@PathVariable int empId){
		return employeeRecordDataDao.getUserLogById(empId);
	}
	
}
