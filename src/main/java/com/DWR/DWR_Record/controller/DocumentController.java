package com.DWR.DWR_Record.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DWR.DWR_Record.dto.DocumentDto;
import com.DWR.DWR_Record.entity.DocumentEntity;
import com.DWR.DWR_Record.service.DocumentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/document")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;
    
    @PostMapping("save")
    public ResponseEntity<DocumentEntity> uploadDocument(
            @RequestParam("documentType") String documentType,
            @RequestParam("employeeId") String employeeId,
            @RequestParam("file") MultipartFile file,
            @RequestParam("description") String description) throws IOException, SQLException {

        DocumentEntity document = new DocumentEntity();
        document.setDocumentType(documentType);
        document.setDescription(description);
        document.setEmployeeId(employeeId);

        Blob fileContent = new SerialBlob(file.getBytes());
        document.setFileContent(fileContent);
        DocumentEntity savedDocument = documentService.saveDocument(document);
        return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
    }
 
    
    @GetMapping("/list/{empId}")
    public List<DocumentDto> getDocumentsByEmployeeId(@PathVariable("empId") String employeeId) {
        List<DocumentEntity> documents = documentService.getDocumentByEmployeeId(employeeId);
        List<DocumentDto> documentDTOs = documents.stream()
        		.map(this::convertToDTO)
                .collect(Collectors.toList());
        return documentDTOs;
    }
    
    private DocumentDto convertToDTO(DocumentEntity documentEntity) {
        // Convert Blob to byte[]
        byte[] fileContent = null;
        try {
            Blob blob = documentEntity.getFileContent();
            int blobLength = (int) blob.length();
            fileContent = blob.getBytes(1, blobLength);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        // Create and return DocumentDTO
        return new DocumentDto(
                documentEntity.getId(),
                documentEntity.getDocumentType(),
                fileContent,
                documentEntity.getDescription(),
                documentEntity.getEmployeeId(),
                documentEntity.getDeleteFlag()
        );
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable("id") Long id) throws SQLException {
        Optional<DocumentEntity> optionalDocument = documentService.getDocumentById(id);

        if (optionalDocument.isPresent()) {
        	DocumentEntity document = optionalDocument.get();
            Blob fileContent = document.getFileContent();
            byte[] bytes = fileContent.getBytes(1, (int) fileContent.length());
            return ResponseEntity
                    .ok()
                    .header("Content-Disposition", "attachment; filename=" + document.getDocumentType())
                    .body(bytes);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
