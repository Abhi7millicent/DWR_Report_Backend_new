package com.DWR.DWR_Record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.EmployeeRecordLogEntity;

public interface EmployeeRecordLogRepository extends JpaRepository<EmployeeRecordLogEntity, Long>{

	@Query(value = "SELECT * FROM employee_record_log_eld WHERE employee_id_eld = :employeeId", nativeQuery = true)
    List<EmployeeRecordLogEntity> getEmployeeRecordListByEmployeeId(@Param("employeeId") String employeeId);	
	
}
