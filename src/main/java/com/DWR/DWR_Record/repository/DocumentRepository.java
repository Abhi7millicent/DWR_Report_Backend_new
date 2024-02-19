package com.DWR.DWR_Record.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.DocumentEntity;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>{
	
	@Query(value = "SELECT * FROM document_master_dm WHERE employeeid_em_dm = :employeeId", nativeQuery = true)
	List<DocumentEntity> findByEmployeeId(@Param("employeeId") String employeeId);
	

}
