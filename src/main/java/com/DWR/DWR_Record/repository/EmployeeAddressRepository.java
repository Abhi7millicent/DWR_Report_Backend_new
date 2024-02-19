package com.DWR.DWR_Record.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.entity.EmployeeAdressEntity;




@EnableJpaRepositories
@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAdressEntity, Long>{

	
	

	@Query(value = "SELECT * FROM employee_address_ed WHERE employeeid_ed = :employeeId and address_type_ed = :addressType", nativeQuery = true)
	Optional<EmployeeAdressEntity> findByEmployeeIdAndAddressType(@Param("employeeId") String employeeId,@Param("addressType") String addressType);
}
