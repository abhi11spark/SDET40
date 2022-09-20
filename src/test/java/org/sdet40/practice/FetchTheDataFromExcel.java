package org.sdet40.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromExcel {

	public static void main(String[] args) throws Exception {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/commondata1.xlsx");
		Workbook wb =WorkbookFactory.create(fisExcel);
		
		String usn = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
	    Cell cell = row.getCell(1);
	    String username = cell.getStringCellValue();
	    System.out.println(usn);
	    wb.close();
		
		

	}

}
