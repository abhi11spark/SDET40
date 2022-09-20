package org.sdet40.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/Ajio.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Ajio");
		String productName = sheet.getRow(1).getCell(0).getStringCellValue();
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--");
		
		
		
		
		
		
		
		
		
		/*WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='Printed Jacket & Joggers Set']/parent::div//child::span[@class='price  ']")).click();
		src/test/resources/Ajio.xlsx*/
		
	}

}
