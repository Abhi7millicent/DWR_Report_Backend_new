package com.DWR.DWR_Record.dto;

public class ProjectDto {
 
	private Long id;
	private String type;
	private String name;
	private String description;
	private String taskId;
	private String startDate;
	private String targetDate;
	private String deleteflag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	
	public ProjectDto(Long id, String type, String name, String description, String taskId, String startDate,
			String targetDate, String deleteflag) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.taskId = taskId;
		this.startDate = startDate;
		this.targetDate = targetDate;
		this.deleteflag = deleteflag;
	}
	public ProjectDto() {
		
	}
	@Override
	public String toString() {
		return "ProjectDto [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description
				+ ", taskId=" + taskId + ", startDate=" + startDate + ", targetDate=" + targetDate + ", deleteflag="
				+ deleteflag + "]";
	}
	
}
