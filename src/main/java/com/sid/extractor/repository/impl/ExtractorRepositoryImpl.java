package com.sid.extractor.repository.impl;

import java.util.List;
import java.util.Map;

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
	public List<Map<String, Object>> fetchData(String date, int limit, List<String> columns) {
		// TODO Auto-generated method stub
		String columnStr = String.join(",", columns);
		String sql = String.format(
                "SELECT %s FROM daily_data WHERE business_date = ? LIMIT ?",
                columnStr
        );
		return jdbcTemplate.queryForList(sql, date, limit);
	}
}
