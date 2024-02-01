package com.DWR.DWR_Record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.ProjectDto;
import com.DWR.DWR_Record.entity.ProjectEntity;
import com.DWR.DWR_Record.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@PostMapping("/save")
	public String AddProject(@RequestBody ProjectDto projectDto) {
		try {
			return projectService.addProject(projectDto);
		}catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
	
	@PostMapping("/save/{id}") 
		public String AddTask(@RequestBody ProjectDto projectDto ,@PathVariable String id) {
			try {
				return projectService.addTask(projectDto, id);
			}catch (Exception e) {
		        e.printStackTrace();
		        // Log the exception or return a meaningful response
		        return null;
		    }
		}
	
	@GetMapping("/list")
	public List<ProjectEntity> getProjectList(){
		try {
			return projectService.getProjectList();
		} catch (Exception e) {
	        e.printStackTrace();
	        // Log the exception or return a meaningful response
	        return null;
	    }
	}
}
