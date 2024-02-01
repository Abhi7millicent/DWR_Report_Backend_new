package com.DWR.DWR_Record.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.entity.EmployeeAdressEntity;




@EnableJpaRepositories
@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAdressEntity, Long>{


}
