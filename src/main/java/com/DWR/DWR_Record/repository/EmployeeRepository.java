package com.DWR.DWR_Record.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.entity.EmployeeEntity;
import java.util.List;


@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	EmployeeEntity findByLoginId(String loginId);
	
	List<EmployeeEntity> getEmployeeByFirstName(String name);
	
	
	@Query(value = "SELECT balanced_leave_em FROM employee_master_em WHERE id_em = :employeeId", nativeQuery = true)
	String getBlancedLeaveById(@Param("employeeId") Long employeeId);
}
