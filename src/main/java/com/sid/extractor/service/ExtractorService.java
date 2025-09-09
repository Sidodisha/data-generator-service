package com.sid.extractor.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface ExtractorService {

	ByteArrayInputStream generateReport(String businessDate, int limit, List<String> columns) throws IOException;
	
}
