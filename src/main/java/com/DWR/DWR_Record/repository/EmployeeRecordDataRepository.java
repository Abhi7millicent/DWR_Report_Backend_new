package com.DWR.DWR_Record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.EmployeeRecordDataEntity;

public interface EmployeeRecordDataRepository extends JpaRepository<EmployeeRecordDataEntity, Long>{

	 @Query(value = "SELECT * FROM employee_record_data_erd WHERE employee_id_erd = :employeeId AND date_erd = :date", nativeQuery = true)
	    List<EmployeeRecordDataEntity> getEmployeeRecordDataListByEmployeeIdAndDate(
	            @Param("employeeId") String employeeId,
	            @Param("date") String date
	    );
	 
	 @Query(value = "SELECT * FROM employee_record_data_erd WHERE employee_id_erd = :employeeId ORDER BY date_erd DESC", nativeQuery = true)
	    List<EmployeeRecordDataEntity> getEmployeeRecordFullDataListByEmployeeIdAndDate(
	            @Param("employeeId") String employeeId
	    );

	 @Query(value = "SELECT * FROM employee_record_data_erd WHERE employee_id_erd = :employeeId AND date_erd BETWEEN :startDate AND :endDate ORDER BY date_erd DESC", nativeQuery = true)
	 List<EmployeeRecordDataEntity> getEmployeeRecordFullDataListBasedOnRange(
	         @Param("employeeId") String employeeId,
	         @Param("startDate") String startDate,
	         @Param("endDate") String endDate);

}
