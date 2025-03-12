package com.sp.controller;

import com.sp.service.FileProcessingService;
import com.sp.service.XmlToJsonConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/")
public class FileProcessingController {

    @Autowired
    private FileProcessingService fileProcessingService;

    @Autowired
    private XmlToJsonConverterService xmlToJsonConverterService;

    // ✅ Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to File Processing Application");
        return "home"; // Ensure home.html exists in src/main/resources/templates/
    }

    // ✅ Upload and Process CSV/Excel File
    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "startRow", defaultValue = "1") int startRow,
            @RequestParam(value = "endRow", defaultValue = "100") int endRow, // Set a reasonable default value
            Model model) {

        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "File is empty. Please upload a valid file.");
            return "error";
        }

        try {
            List<List<String>> fileData = fileProcessingService.processFile(file, startRow, endRow);
            if (fileData.isEmpty()) {
                model.addAttribute("message", "File uploaded successfully, but no data found.");
            } else {
                model.addAttribute("data", fileData);
            }
            return "result";
        } catch (Exception e) {
            model.addAttribute("error", "Error processing the file: " + e.getMessage());
            return "error";
        }
    }

    // ✅ Fetch a Specific Cell Value from Excel
    @PostMapping("/fetch-cell")
    public ResponseEntity<String> fetchExcelCell(
            @RequestParam("file") MultipartFile file,
            @RequestParam("row") int row,
            @RequestParam("column") int column) {
        
        if (file == null || file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: File is empty. Please upload a valid Excel file.");
        }

        try {
            String cellValue = fileProcessingService.extractExcelCell(file, row, column);
            return ResponseEntity.ok(cellValue);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching cell value: " + e.getMessage());
        }
    }

    // ✅ Convert XML to JSON
    @PostMapping("/convert")
    public String convertXmlToJson(@RequestParam("file") MultipartFile file, Model model) {
        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "File is empty. Please upload a valid XML file.");
            return "error";
        }

        try {
            String jsonFilePath = xmlToJsonConverterService.convertXmlToJson(file);
            model.addAttribute("message", "JSON saved at: " + jsonFilePath);
            return "result";
        } catch (org.xml.sax.SAXParseException e) {
            model.addAttribute("error", "XML Parsing Error at line " + e.getLineNumber() + 
                    ", column " + e.getColumnNumber() + ": " + e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "Error processing XML file: " + e.getMessage());
            return "error";
        }
    }

    // ✅ Download JSON File
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadJsonFile(@RequestParam("filePath") String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }
}
