package com.sid.extractor.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.extractor.dto.ExtractorDto;
import com.sid.extractor.service.ExtractorService;

@RestController
@RequestMapping("/api/v1/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class ExtractorController {

	private ExtractorService extractorService;

	public ExtractorController(ExtractorService extractorService) {
		this.extractorService = extractorService;
	}
	
	@PostMapping("/generate")
	public ResponseEntity<InputStreamResource> generateReport(@RequestBody ExtractorDto request) throws IOException {
        ByteArrayInputStream inputStream = extractorService.generateReport(
               request.getBusinessDate(),
                request.getLimit(),
                request.getColumns()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=report.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(new InputStreamResource(inputStream)); 
	}
	
}
