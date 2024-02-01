package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_master_pm")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pm")
	private Long id;
	@Column(name = "type_pm")
	private String type;
	@Column(name = "name_pm")
	private String name;
	@Column(name = "description_pm")
	private String description;
	@Column(name = "task_id_pm")
	private String taskId;
	@Column(name = "start_date_pm")
	private String startDate;
	@Column(name = "target_date_pm")
	private String targetDate;
	@Column(name = "deleteflag_pm", columnDefinition = "VARCHAR(3) DEFAULT 'No'")
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
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
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
	public ProjectEntity(Long id, String type, String name, String description, String taskId, String startDate,
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
	
	public ProjectEntity() {
		
	}
	
	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", type=" + type + ", name=" + name + ", description=" + description
				+ ", taskId=" + taskId + ", startDate=" + startDate + ", targetDate=" + targetDate + ", deleteflag="
				+ deleteflag + "]";
	}
	
	
}
