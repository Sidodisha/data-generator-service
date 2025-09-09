package com.sid.extractor.repository;

import java.util.List;
import java.util.Map;

public interface ExtractorRepository {

	List<Map<String, Object>> fetchData(String date, int limit, List<String> columns);
}
