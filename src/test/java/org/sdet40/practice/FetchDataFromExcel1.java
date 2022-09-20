package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel1 {

	public static void main(String[] args) throws Exception {
	FileInputStream fisExcel = new FileInputStream("./src/test/resources/commondata1.xlsx");
	Workbook wb= WorkbookFactory.create(fisExcel);
	DataFormatter df =new DataFormatter();
	try {
		Sheet sheet = wb.getSheet("Sheet1");
		Cell cell = sheet.getRow(3).getCell(1);
		String a1 = df.formatCellValue(cell);
		System.out.println(cell.toString());
		System.out.println(cell.getNumericCellValue());
		System.out.println(cell.getStringCellValue());
		System.out.println(a1);
		
	}
	finally {
		wb.close();
		
	}

	}

}
