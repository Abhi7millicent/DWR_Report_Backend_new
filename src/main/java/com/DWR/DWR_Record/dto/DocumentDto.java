package com.DWR.DWR_Record.dto;

import java.util.Arrays;

public class DocumentDto {
	private Long id;
    private String documentType;
    private byte[] fileContent; // Change to byte[] instead of Blob
    private String description;
    private String employeeId;
    private String deleteFlag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public DocumentDto(Long id, String documentType, byte[] fileContent, String description, String employeeId,
			String deleteFlag) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.fileContent = fileContent;
		this.description = description;
		this.employeeId = employeeId;
		this.deleteFlag = deleteFlag;
	}

	public DocumentDto() {
		
	}
	@Override
	public String toString() {
		return "DocumentDto [id=" + id + ", documentType=" + documentType + ", fileContent="
				+ Arrays.toString(fileContent) + ", description=" + description + ", employeeId=" + employeeId
				+ ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
