package com.DWR.DWR_Record.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "email_log_details_eld")
public class EmailLogDetailsEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_eld")
	 private Long id;
	 @Column(name = "email_eld")
	 private String email;
	 @Column(name = "name_eld")
	 private String name;
	 @Column(name = "date_time_eld")
	 private String dateTime;
	 @Column(name = "type_eld")
	 private String logType;
	 @Column(name = "attachment_eld")
	 private byte[] attachment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	
	 
	public EmailLogDetailsEntity(Long id, String email, String name, String dateTime, String logType,
			byte[] attachment) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.dateTime = dateTime;
		this.logType = logType;
		this.attachment = attachment;
	}
	public EmailLogDetailsEntity () {
		
	}
	@Override
	public String toString() {
		return "EmailLogDetailsEntity [id=" + id + ", email=" + email + ", name=" + name + ", dateTime=" + dateTime
				+ ", logType=" + logType + ", attachment=" + Arrays.toString(attachment) + "]";
	}
	
	
	
	
	 
}
