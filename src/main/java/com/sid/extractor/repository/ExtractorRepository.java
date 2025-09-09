package com.sid.extractor.repository;

import java.util.List;

public interface ExtractorRepository {

	List<List<Object>> fetchDynamicData(String businessDate, int limit, List<String> columns);
}
