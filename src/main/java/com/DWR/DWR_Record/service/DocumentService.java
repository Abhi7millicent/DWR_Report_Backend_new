package com.DWR.DWR_Record.service;


import java.util.List;
import java.util.Optional;

import com.DWR.DWR_Record.entity.DocumentEntity;

public interface DocumentService {

	DocumentEntity saveDocument(DocumentEntity document);

	Optional<DocumentEntity> getDocumentById(Long id);

	List<DocumentEntity> getDocumentByEmployeeId(String employeeId);



}
