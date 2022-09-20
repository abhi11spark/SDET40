package org.tyss.ProvidenceSMS.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists Actions performing on excel workbook
 * 
 * @author Abhishek K H
 *
 */
public class ExcelUtility {
	Workbook workbook;
	FileOutputStream fosExcel;

	/**
	 * This method is used to initialize the workbook
	 * 
	 * @param excelPath
	 */
	public void initializeExcel(String excelPath) {

		FileInputStream fisExcel = null;

		try {
			fisExcel = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException | IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method consists of codes to fetch data(formated data) from excel
	 * workbook
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcelFile(String sheetName, int rowNumber, int cellNumber) {

		Sheet sheet = workbook.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	public Map<String, String> getDataFromExcelFile(String sheetName, String expectedValue) {
		Sheet sheet = workbook.getSheet(sheetName);
		Map<String, String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedValue)) {
				for (int j = i; j <= sheet.getLastRowNum(); j++) {
					map.put(df.formatCellValue(sheet.getRow(j).getCell(2)),
							df.formatCellValue(sheet.getRow(j).getCell(3)));
					if (df.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break;
			}
		}
		return map;
	}
	

	/**
	 * This method is used to fetch the data from the excel based on the key
	 * 
	 * @param sheetName
	 * @param requiredKey
	 * @return
	 */
	/*
	 * public String getDataFromExcelFile(String sheetName, String requiredKey) {
	 * Sheet sheet = workbook.getSheet(sheetName); String value = null; for (int i =
	 * 0; i <= sheet.getLastRowNum(); i++) { String actualKey =
	 * sheet.getRow(i).getCell(3).getStringCellValue(); if
	 * (actualKey.equalsIgnoreCase(requiredKey)) { value =
	 * sheet.getRow(i).getCell(3).getStringCellValue(); } } return value;
	 * 
	 * }
	 */

	/**
	 * This method is used to write data to Excel
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public void writeToExcel(String sheetName, int rowNumber, int cellNumber, String value) {
		try {
			fosExcel = new FileOutputStream(IConstantUtility.EXCEL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.createCell(cellNumber);
		cell.setCellValue(value);
		try {
			workbook.write(fosExcel);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void closeExcelWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
