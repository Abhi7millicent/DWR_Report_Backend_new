package com.DWR.DWR_Record.controller;

import java.io.IOException; // Correct import
import java.util.List;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Workbook;
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

import com.DWR.DWR_Record.entity.EmployeeRecordDataEntity;
import com.DWR.DWR_Record.repository.EmployeeRecordDataRepository;
import com.DWR.DWR_Record.service.EmployeeRecordDataService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/employeeRecordData")
public class EmployeeRecordDataController {

    @Autowired
    private EmployeeRecordDataService employeeRecordDataService;
    
    @Autowired
    private EmployeeRecordDataRepository employeeRecordDataRepository;

    @GetMapping("/list/{empId}/{date}")
    public List<EmployeeRecordDataEntity> getEmployeeRecordDataList(@PathVariable("empId") String employeeId,
            @PathVariable String date) {
        try {
            return employeeRecordDataService.getEmployeeRecordDataList(employeeId, date);
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception or return a meaningful response
            return null;
        }
    }

    @GetMapping("/list/{empId}")
    public List<EmployeeRecordDataEntity> getEmployeeRecordFullDataList(@PathVariable("empId") String employeeId) {
        try {
            return employeeRecordDataService.getEmployeeRecordFullDataList(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception or return a meaningful response
            return null;
        }
    }
    
    
    
    @GetMapping("/list/{empId}/{startDate}/{endDate}")
    public List<EmployeeRecordDataEntity> getEmployeeRecordFullDataListBasedOnRange(@PathVariable("empId") String employeeId, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
        try {
            return employeeRecordDataService.getEmployeeRecordFullDataListBasedOnRange(employeeId, startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception or return a meaningful response
            return null;
        }
    }

    @GetMapping("/download/{empId}")
    public void downloadExcel(HttpServletResponse response, @PathVariable("empId") String employeeId) throws IOException {
        try {
            // Fetch data from the database
            List<EmployeeRecordDataEntity> employeeRecords = employeeRecordDataService
                    .getEmployeeRecordFullDataList(employeeId);
            
            Workbook workbook = employeeRecordDataService.generateExcelWorkbook(employeeRecords);


            // Set the response headers
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=EmployeeRecords.xlsx");

            // Write the workbook content to the response
            workbook.write(response.getOutputStream());

            // Close the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception or return a meaningful response
        }
    }
    
    @GetMapping("/download/{empId}/{startDate}/{endDate}")
    public void downloadExcel(HttpServletResponse response, @PathVariable("empId") String employeeId, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws IOException {
        try {
            // Fetch data from the database
            List<EmployeeRecordDataEntity> employeeRecords = employeeRecordDataService
                    .getEmployeeRecordFullDataListBasedOnRange(employeeId, startDate, endDate);
            
            Workbook workbook = employeeRecordDataService.generateExcelWorkbook(employeeRecords);


            // Set the response headers
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=EmployeeRecords.xlsx");

            // Write the workbook content to the response
            workbook.write(response.getOutputStream());

            // Close the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception or return a meaningful response
        }
    }
    
    
    @PostMapping("/import/{empId}")
    public ResponseEntity<String> importExcelData(@RequestParam("file") MultipartFile file,  @PathVariable("empId") String employeeId) {
        try {
            List<EmployeeRecordDataEntity> data = employeeRecordDataService.readDataFromExcel(file.getInputStream(), employeeId);
            employeeRecordDataRepository.saveAll(data);
            return ResponseEntity.ok("Data imported successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing data: " + e.getMessage());
        }
    }
//    @GetMapping("/downloadpdf/{empId}")
//    public void downloadPdf(HttpServletResponse response, @PathVariable("empId") String employeeId) throws IOException {
//        try {
//            // Fetch data from the database
//            List<EmployeeRecordDataEntity> employeeRecords = employeeRecordDataService
//                    .getEmployeeRecordFullDataList(employeeId);
//
//            // Create a PDF document
//            PDDocument document = new PDDocument();
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            // Create content stream
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Write content to the PDF
//            writePdfContent(contentStream, employeeRecords);
//
//            // Close the content stream and save the document
//            contentStream.close();
//
//            // Set the response headers
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=EmployeeRecords.pdf");
//
//            // Write the PDF document to the response
//            document.save(response.getOutputStream());
//
//            // Close the document
//            document.close();
//        } catch (IOException e) {
//            // Return a meaningful response to the client
//            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            response.getWriter().write("Error generating PDF file");
//        }
//    }
//
//    private void writePdfContent(PDPageContentStream contentStream, List<EmployeeRecordDataEntity> employeeRecords) throws IOException {
//        // Write content to the PDF, similar to how you filled the Excel workbook
//        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//        float margin = 50;
//        float yStart = 700; // Starting y-position
//        float tableWidth = 500; // Adjust based on your layout
//        float yPosition = yStart;
//        float rowHeight = 15;
//        float tableMargin = 10;
//
//        // Draw headers
//        contentStream.beginText();
//        contentStream.newLineAtOffset(margin, yPosition);
//        contentStream.showText("ID");
//        contentStream.newLineAtOffset(20, 0);
////        contentStream.showText("Employee ID");
////        contentStream.newLineAtOffset(100, 0);
//        contentStream.showText("Date");
//        contentStream.newLineAtOffset(70, 0);
//        contentStream.showText("From Time");
//        contentStream.newLineAtOffset(70, 0);
//        contentStream.showText("To Time");
//        contentStream.newLineAtOffset(70, 0);
//        contentStream.showText("Project Name");
//        contentStream.newLineAtOffset(90, 0);
//        contentStream.showText("Task Description");
//        contentStream.newLineAtOffset(100, 0);
//        contentStream.showText("Reported By");
//        contentStream.newLineAtOffset(400, 0);
//        contentStream.showText("Ticket Type");
//        contentStream.newLineAtOffset(450, 0);
//        contentStream.showText("Status");
//        contentStream.newLineAtOffset(500, 0);
//        contentStream.showText("Solution");
//        contentStream.endText();
//
//        // Draw table content
//        yPosition -= rowHeight;
//        for (EmployeeRecordDataEntity record : employeeRecords) {
//            contentStream.beginText();
//            contentStream.newLineAtOffset(margin, yPosition);
//
//            // Example null checks; replace with your actual field names
//            contentStream.showText(String.valueOf(record.getId()));
//            contentStream.newLineAtOffset(20, 0);
////            contentStream.showText(getNotNullString(record.getEmployeeId()));
////            contentStream.newLineAtOffset(100, 0);
//            contentStream.showText(getNotNullString(record.getDate()));
//            contentStream.newLineAtOffset(70, 0);
//            contentStream.showText(getNotNullString(record.getFromTime()));
//            contentStream.newLineAtOffset(70, 0);
//            contentStream.showText(getNotNullString(record.getToTime()));
//            contentStream.newLineAtOffset(70, 0);
//            contentStream.showText(getNotNullString(record.getProjectName()));
//            contentStream.newLineAtOffset(90, 0);
//            contentStream.showText(getNotNullString(record.getTaskDiscription()));
//            contentStream.newLineAtOffset(100, 0);
//            contentStream.showText(getNotNullString(record.getReportedBy()));
//            contentStream.newLineAtOffset(400, 0);
//            contentStream.showText(getNotNullString(record.getTicketType()));
//            contentStream.newLineAtOffset(450, 0);
//            contentStream.showText(getNotNullString(record.getStatus()));
//            contentStream.newLineAtOffset(500, 0);
//            contentStream.showText(getNotNullString(record.getSolution()));
//
//            contentStream.endText();
//            yPosition -= rowHeight + tableMargin; // Adjust line spacing and margin as needed
//        }
//    }
//
//    // Add a method to handle null values
//    private String getNotNullString(String value) {
//        return value != null ? value : "";
//    }

}
