//package com.DWR.DWR_Record.helper;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.DWR.DWR_Record.entity.EmployeeRecordDataEntity;
//
//@Component
//public class ExcelToDatabaseHelper {
//
//    public static boolean checkExcelFormat(MultipartFile file) {
//        String contentType = file.getContentType();
//        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//    }
//
//    // This method converts Excel to a list of Data
//    public static List<EmployeeRecordDataEntity> convertExcelToListOfData(InputStream input) {
//        List<EmployeeRecordDataEntity> list = new ArrayList<>();
//        try (XSSFWorkbook workbook = new XSSFWorkbook(input)) {
//            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming you want the first sheet
//
//            Iterator<Row> iterator = sheet.iterator();
//
//            // Skip the header row
//            if (iterator.hasNext()) {
//                iterator.next();
//            }
//
//            while (iterator.hasNext()) {
//                Row row = iterator.next();
//                EmployeeRecordDataEntity data = new EmployeeRecordDataEntity();
//
//                // Use for-each loop for cells, it's simpler
//                int cid = 2; // Assuming your data starts from column 1
//                for (Cell cell : row) {
//                    switch (cid) {
//                        case 2:
//                            data.setDate(cell.getDateCellValue());
//                            break;
//                        case 3:
//                            data.setFromTime(cell.getNumericCellValue());
//                            break;
//                        case 4:
//                            data.setToTime(cell.getNumericCellValue());
//                            break;
//                        case 5:
//                            data.setProjectName(cell.getStringCellValue());
//                            break;
//                        case 6:
//                            data.setTaskDiscription(cell.getStringCellValue());
//                            break;
//                        case 7:
//                            data.setReportedBy(cell.getStringCellValue());
//                            break;
//                        case 8:
//                            data.setTicketType(cell.getStringCellValue());
//                            break;
//                        case 9:
//                            data.setStatus(cell.getStringCellValue());
//                            break;
//                        case 10:
//                            data.setSolution(cell.getStringCellValue());
//                            break;
//                        case 11:
//                            data.setEmployeeId(cell.getNumericCellValue()); 
//                            break;
//                            
//                        default:
//                            break;
//                    }
//                    cid++;
//                }
//
//                list.add(data);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}
