package com.DWR.DWR_Record.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_master_dm")
public class DocumentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dm")
	private Long id;
	@Column(name = "document_type_dm")
    private String documentType;
	@Column(name = "file_content_dm")
    @Lob
    private Blob fileContent;
	@Column(name = "description_dm")
    private String description;
	@Column(name = "employeeid_em_dm")
    private String EmployeeId;
	@Column(name = "deleteflag_dm", columnDefinition = "VARCHAR(3) DEFAULT 'No'")
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
	public Blob getFileContent() {
		return fileContent;
	}
	public void setFileContent(Blob fileContent) {
		this.fileContent = fileContent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
	
	public DocumentEntity(Long id, String documentType, Blob fileContent, String description, String employeeId,
			String deleteFlag) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.fileContent = fileContent;
		this.description = description;
		EmployeeId = employeeId;
		this.deleteFlag = deleteFlag;
	}
	public DocumentEntity() {
		
	}
	@Override
	public String toString() {
		return "DocumentEntity [id=" + id + ", documentType=" + documentType + ", fileContent=" + fileContent
				+ ", description=" + description + ", EmployeeId=" + EmployeeId + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
}
