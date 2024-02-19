package com.DWR.DWR_Record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.EmployeeEducationalDetailsEntity;

public interface EmployeeEducationalDetailsRepository extends JpaRepository<EmployeeEducationalDetailsEntity, Long>{

	@Query(value = "SELECT * FROM employee_educational_details_eed WHERE emp_id_eed = :employeeId and deleteflag_eed = 'NO'", nativeQuery = true)
	List<EmployeeEducationalDetailsEntity> getEducationalDetailListById(@Param("employeeId") String employeeId);



	

}
