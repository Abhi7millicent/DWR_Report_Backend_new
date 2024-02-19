package com.DWR.DWR_Record.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;

public interface EmployeePersonalDetailsRepository extends JpaRepository<EmployeePersonalDetailsEntity, Long>{
	
	@Query(value = "SELECT * FROM employee_personal_details_epd WHERE employee_id_epd = :employeeId", nativeQuery = true)
	Optional<EmployeePersonalDetailsEntity> findByEmployeeId(@Param("employeeId") String employeeId);

}
