package com.DWR.DWR_Record.serviceIMPL;


import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DWR.DWR_Record.entity.EmployeeRecordDataEntity;
import com.DWR.DWR_Record.repository.EmployeeRecordDataRepository;
import com.DWR.DWR_Record.service.EmployeeRecordDataService;

@Service
public class EmployeeRecordDataServiceImpl implements EmployeeRecordDataService {

    @Autowired
    private EmployeeRecordDataRepository employeeRecordDataRepository;

    @Override
    public List<EmployeeRecordDataEntity> getEmployeeRecordDataList(String employeeId, String date) {
        return employeeRecordDataRepository.getEmployeeRecordDataListByEmployeeIdAndDate(employeeId, date);
    }

    @Override
    public List<EmployeeRecordDataEntity> getEmployeeRecordFullDataList(String employeeId) {
        return employeeRecordDataRepository.getEmployeeRecordFullDataListByEmployeeIdAndDate(employeeId);
    }

    @Override
    public Workbook generateExcelWorkbook(List<EmployeeRecordDataEntity> employeeRecords) {
        Workbook workbook = new XSSFWorkbook();

        try {
            Sheet sheet = workbook.createSheet("Employee Records");

            createHeaderRow(sheet);

            int rowNum = 1;
            for (EmployeeRecordDataEntity record : employeeRecords) {
                Row row = sheet.createRow(rowNum++);
                fillDataRow(row, record);
            }
        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log it or throw a custom exception
            e.printStackTrace();
        }

        return workbook;
    }

    private void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Employee ID", "Date", "From Time", "To Time", "Project Name",
                "Task Description", "Reported By", "Ticket Type", "Status", "Solution"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private void fillDataRow(Row row, EmployeeRecordDataEntity record) {
        row.createCell(0).setCellValue(record.getId());
        row.createCell(1).setCellValue(record.getEmployeeId());
        row.createCell(2).setCellValue(record.getDate());
        row.createCell(3).setCellValue(record.getFromTime());
        row.createCell(4).setCellValue(record.getToTime());
        row.createCell(5).setCellValue(record.getProjectName());
        row.createCell(6).setCellValue(record.getTaskDiscription()); // Corrected typo in method name
        row.createCell(7).setCellValue(record.getReportedBy());
        row.createCell(8).setCellValue(record.getTicketType());
        row.createCell(9).setCellValue(record.getStatus());
        row.createCell(10).setCellValue(record.getSolution());
    }

	@Override
	public List<EmployeeRecordDataEntity> getEmployeeRecordFullDataListBasedOnRange(String employeeId, String startDate,
			String endDate) {
		return employeeRecordDataRepository.getEmployeeRecordFullDataListBasedOnRange(employeeId, startDate, endDate);
		
	}

	 @Override
	    public List<EmployeeRecordDataEntity> readDataFromExcel(InputStream inputStream, String employeeId) {
	        List<EmployeeRecordDataEntity> records = new ArrayList<>();

	        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
	            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

	            Iterator<Row> rowIterator = sheet.iterator();
	            // Skipping header row assuming the first row contains column headers
	            if (rowIterator.hasNext()) {
	                rowIterator.next();
	            }

	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                EmployeeRecordDataEntity record = createRecordFromRow(row, employeeId);
	                records.add(record);
	            }
	        } catch (IOException e) {
	            // Handle or log the exception as needed
	            e.printStackTrace();
	        }

	        return records;
	    }

	    private EmployeeRecordDataEntity createRecordFromRow(Row row, String employeeId) {
	        EmployeeRecordDataEntity record = new EmployeeRecordDataEntity();

//	        record.setEmployeeId(getStringValue(row.getCell(11)));
	        record.setEmployeeId(employeeId);
	        record.setDate(formatDate(row.getCell(1)));
	        record.setFromTime(formatTime(row.getCell(2)));
	        record.setToTime(formatTime(row.getCell(3)));
	        record.setProjectName(getStringValue(row.getCell(4)));
	        record.setTaskDiscription(getStringValue(row.getCell(5)));
	        record.setReportedBy(getStringValue(row.getCell(6)));
	        record.setTicketType(getStringValue(row.getCell(7)));
	        record.setStatus(getStringValue(row.getCell(8)));
	        record.setSolution(getStringValue(row.getCell(10)));
	        
	        return record;
	    }
	    
	    private String formatTime(Cell cell) {
	    	if (cell.getCellType() == CellType.NUMERIC) {
                // Check if the numeric value is a date
                if (DateUtil.isCellDateFormatted(cell)) {
                    // If it's a date, you can get the date value
                    LocalDateTime dateValue = cell.getLocalDateTimeCellValue();
                    System.out.println("time: " + dateValue);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                    // Format the LocalDateTime object using the formatter
                    String formattedTime = dateValue.format(formatter);
                    return formattedTime;
                }
                return null;
	    	} else {
                // Handle other cell types if needed
                System.out.println("Cell does not contain a numeric value.");
                return null;
            }
	    }
	    
	    private String formatDate(Cell cell) {
	    	if (cell.getCellType() == CellType.NUMERIC) {
                // Check if the numeric value is a date
                if (DateUtil.isCellDateFormatted(cell)) {
                    // If it's a date, you can get the date value
                    Date dateValue = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    // Setting the time zone to IST (Indian Standard Time)
                    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

                    // Formatting the date and converting it to a string
                    String formattedDate = sdf.format(dateValue);
                    // Printing the result
                    System.out.println(formattedDate);
                    return formattedDate;
                }
                return null;
            } else {
                // Handle other cell types if needed
                System.out.println("Cell does not contain a numeric value.");
                return null;
            }
	    }

	    

	    private String getStringValue(Cell cell) {
	        if (cell == null) {
	            return null;
	        }

	        if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	            return formatNumericValue(cell.getNumericCellValue());
	        } else {
	            // Handle other cell types as needed
	            return null;
	        }
	    }

	    private String formatNumericValue(double numericValue) {
	        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Adjust the format as needed
	        return decimalFormat.format(numericValue);
	    }
}