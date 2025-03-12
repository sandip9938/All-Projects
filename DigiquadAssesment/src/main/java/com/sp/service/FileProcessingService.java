package com.sp.service;

import org.apache.commons.csv.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class FileProcessingService {

    // ✅ Process CSV: Extracts rows within startRow and endRow
    private List<List<String>> processCSV(MultipartFile file, int startRow, int endRow) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                int rowNum = (int) record.getRecordNumber(); // CSVRecord starts from 1
                if (rowNum >= startRow && rowNum <= endRow) {
                    data.add(new ArrayList<>(record.toList()));
                }
            }
        }
        return data;
    }

    // ✅ Process Excel: Extracts rows within startRow and endRow
    private List<List<String>> processExcel(MultipartFile file, int startRow, int endRow) throws IOException {
        List<List<String>> data = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int rowNum = row.getRowNum(); // Row index starts from 0
                if (rowNum >= startRow && rowNum <= endRow) { // Process only within the given range
                    List<String> rowData = new ArrayList<>();
                    for (Cell cell : row) {
                        rowData.add(cell.toString()); // Convert each cell value to String
                    }
                    data.add(rowData);
                }
            }
        }
        return data;
    }

    // ✅ Extracts a specific cell value from Excel based on row and column number
    public String extractExcelCell(MultipartFile file, int row, int column) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
            Row selectedRow = sheet.getRow(row); // Get the specific row

            if (selectedRow != null) {
                Cell selectedCell = selectedRow.getCell(column); // Get the specific column
                if (selectedCell != null) {
                    return getCellValue(selectedCell); // Convert cell value to String
                } else {
                    return "Column index out of bounds or empty cell!";
                }
            } else {
                return "Row index out of bounds!";
            }
        }
    }

    // ✅ Helper method to convert cell values correctly
    private String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString(); // Convert Date to String
                }
                return String.valueOf(cell.getNumericCellValue()); // Convert Number to String
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula(); // Return formula if any
            case BLANK:
                return "";
            default:
                return "Unknown Cell Type!";
        }
    }

    // ✅ Main method to process file (calls CSV or Excel processor)
    public List<List<String>> processFile(MultipartFile file, int startRow, int endRow) throws Exception {
        if (file.getOriginalFilename().endsWith(".csv")) {
            return processCSV(file, startRow, endRow);
        } else if (file.getOriginalFilename().endsWith(".xlsx")) {
            return processExcel(file, startRow, endRow); // ✅ Now calls the correct method
        }
        throw new IllegalArgumentException("Unsupported file format.");
    }
}
