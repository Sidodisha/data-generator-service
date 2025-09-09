package com.sid.extractor.repository.impl;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sid.extractor.repository.ExtractorRepository;

@Repository
public class ExtractorRepositoryImpl implements ExtractorRepository {

	private final JdbcTemplate jdbcTemplate;

	public ExtractorRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<List<Object>> fetchDynamicData(String businessDate, int limit, List<String> columns) {
		String columnStr = String.join(",", columns);

		String query = "SELECT " + columnStr + " FROM daily_data WHERE business_date = ? LIMIT ?";
		return jdbcTemplate.query(query, (rs, rowNum) -> {
	        return columns.stream()
	                .map(col -> {
	                    try {
	                        return rs.getObject(col);
	                    } catch (Exception e) {
	                        return null;
	                    }
	                }).toList();
	    }, businessDate, limit);
	}
}
