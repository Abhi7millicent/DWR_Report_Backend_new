package com.DWR.DWR_Record.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DWR.DWR_Record.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{
	
	@Query(value = "SELECT taskId FROM project_master_pm WHERE id_pm = :id", nativeQuery = true)
	String getTaskIdById(@Param("id") String id);

}
