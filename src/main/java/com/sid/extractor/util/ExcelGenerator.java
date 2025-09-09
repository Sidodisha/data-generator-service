package com.sid.extractor.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {

	public static ByteArrayInputStream generateExcel(List<String> columns, List<List<Object>> data) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.createSheet("Report");

			// Header Row
			Row headerRow = sheet.createRow(0);
			for (int i = 0; i < columns.size(); i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns.get(i));
			}

			// Data Rows
			for (int i = 0; i < data.size(); i++) {
				Row dataRow = sheet.createRow(i + 1);
				List<Object> row = data.get(i);

				for (int j = 0; j < row.size(); j++) {
					Cell cell = dataRow.createCell(j);
					Object value = row.get(j);

					if (value != null) {
						cell.setCellValue(value.toString());
					} else {
						cell.setCellValue("");
					}
				}
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate Excel report: " + e.getMessage());
		}
	}

}
