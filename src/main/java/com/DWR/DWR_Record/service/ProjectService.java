package com.DWR.DWR_Record.service;

import java.util.List;

import com.DWR.DWR_Record.dto.ProjectDto;
import com.DWR.DWR_Record.entity.ProjectEntity;

public interface ProjectService {

	String addProject(ProjectDto projectDto);

	String addTask(ProjectDto projectDto, String id);

	List<ProjectEntity> getProjectList();

}
