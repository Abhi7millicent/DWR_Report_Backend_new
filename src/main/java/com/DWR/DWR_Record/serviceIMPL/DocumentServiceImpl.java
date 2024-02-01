package com.DWR.DWR_Record.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.entity.DocumentEntity;
import com.DWR.DWR_Record.repository.DocumentRepository;
import com.DWR.DWR_Record.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public DocumentEntity saveDocument(DocumentEntity document) {
        return documentRepository.save(document);
    }

    @Override
    public Optional<DocumentEntity> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

	@Override
	public List<DocumentEntity> getDocumentByEmployeeId(String employeeId) {
		return documentRepository.findByEmployeeId(employeeId);
	}

}
