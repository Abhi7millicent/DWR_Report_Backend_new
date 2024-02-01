package com.DWR.DWR_Record.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.DWR.DWR_Record.entity.EmployeePersonalDetailsEntity;



@EnableJpaRepositories
@Repository
public interface EmployeePersonalDetailsRepository extends JpaRepository<EmployeePersonalDetailsEntity, Long>{


}
