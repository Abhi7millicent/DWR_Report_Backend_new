package com.DWR.DWR_Record.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.entity.EmployeeSalaryEntity;



@EnableJpaRepositories
@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalaryEntity, Long>{
	
	
	@Query(value = "SELECT * FROM employee_salary_es WHERE emp_id_es = :employeeId", nativeQuery = true)
	Optional<EmployeeSalaryEntity> findByEmployeeId(@Param("employeeId") String employeeId);
	
	@Query(value = "SELECT * FROM employee_salary_es WHERE emp_id_es = :employeeId", nativeQuery = true)
	Optional<EmployeeSalaryEntity> findByEmployeeId(@Param("employeeId") Long employeeId);



}
