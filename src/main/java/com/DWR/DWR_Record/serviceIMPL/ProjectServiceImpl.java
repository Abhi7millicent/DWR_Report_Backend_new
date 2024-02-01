package com.DWR.DWR_Record.serviceIMPL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.dto.ProjectDto;
import com.DWR.DWR_Record.entity.ProjectEntity;
import com.DWR.DWR_Record.repository.ProjectRepository;
import com.DWR.DWR_Record.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public String addProject(ProjectDto projectDto) {
        ProjectEntity project = new ProjectEntity(
                projectDto.getId(),
                projectDto.getType(),
                projectDto.getName(),
                projectDto.getDescription(), // Corrected the typo in the property name
                "",
                projectDto.getStartDate(),
                projectDto.getTargetDate(),
                "NO"
        );
        projectRepository.save(project);
        return project.getname(); // Corrected the method call to get the project name
    }

	@Override
	public String addTask(ProjectDto projectDto, String id) {
		ProjectEntity Task = new ProjectEntity(
                projectDto.getId(),
                projectDto.getType(),
                projectDto.getName(),
                projectDto.getDescription(), // Corrected the typo in the property name
                id,
                projectDto.getStartDate(),
                projectDto.getTargetDate(),
                "NO"
        );
		projectRepository.save(Task);
//		Long Id = Task.getId();
//		String taskId = projectRepository.getTaskIdById(id);
//		String newTaskId = taskId + Id.toString();
//		ProjectEntity savedTask = projectRepository.findById(Id)
//	            .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
//		savedTask.setTaskId(newTaskId);
//		projectRepository.save(savedTask);
		return Task.getname();
	}

	@Override
	public List<ProjectEntity> getProjectList() {
		return projectRepository.findAll();
	}

	
    
    
}
