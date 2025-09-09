package com.sid.extractor.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtractorDto {

	private String businessDate;
	private int limit;
	private List<String> columns;

}
