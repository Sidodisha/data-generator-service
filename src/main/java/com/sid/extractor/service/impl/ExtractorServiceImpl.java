package com.sid.extractor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sid.extractor.repository.ExtractorRepository;
import com.sid.extractor.service.ExtractorService;
import com.sid.extractor.util.ExcelGenerator;

@Service
public class ExtractorServiceImpl implements ExtractorService{

	private final ExtractorRepository extractorRepository;

	public ExtractorServiceImpl(ExtractorRepository extractorRepository) {
		this.extractorRepository = extractorRepository;
	}

	@Override
	public ByteArrayInputStream generateReport(String businessDate, int limit, List<String> columns)
			throws IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> data = extractorRepository.fetchData(businessDate, limit, columns);
        return ExcelGenerator.generateExcel(data, columns);
	}
	
}
