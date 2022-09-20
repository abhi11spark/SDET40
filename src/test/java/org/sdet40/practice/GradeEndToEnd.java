package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GradeEndToEnd {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		FileInputStream fisExcel = new FileInputStream("./src/test/resources/commondata1.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);

		String url = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		String usn = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String pwd = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("email")).sendKeys(usn);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("btnSubmit")).click();
		String message = driver
				.findElement(By.xpath("//h5[text()='Abhishek K H,']/descendant::span[text()=' Welcome back! ']"))
				.getText();
		System.out.println(message);
		if (message.equals("Welcome back!")) {
			System.out.println("Login is sucessfull..");
		} else {
			System.out.println("Login is failure..");
		}

		driver.findElement(By.xpath("//span[text()='Grade']")).click();

		String na = wb.getSheet("Grade").getRow(0).getCell(1).getStringCellValue();
		String af = wb.getSheet("Grade").getRow(1).getCell(1).getStringCellValue();
		String hc = wb.getSheet("Grade").getRow(2).getCell(1).getStringCellValue();
		String range = wb.getSheet("Grade").getRow(3).getCell(1).getStringCellValue();
		String grade = wb.getSheet("Grade").getRow(4).getCell(1).getStringCellValue();

		driver.findElement(By.id("name")).sendKeys(na);
		System.out.println(na);
		driver.findElement(By.id("admission_fee")).sendKeys(af);
		driver.findElement(By.id("hall_charge")).sendKeys(hc);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.id("mark_range_text_1")).sendKeys(range);
		driver.findElement(By.id("mark_grade_text_1")).sendKeys(grade);
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit1")).click();
		Thread.sleep(4000);

		WebElement scroll = driver.findElement(By.xpath("//div[@id='example1_paginate']"));
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

		Thread.sleep(2000);
		List<WebElement> gradeList = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));
		int a = gradeList.size();
		
		String gr = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[2]")).getText();
		System.out.println(gr);
		String ad = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[3]")).getText();
		System.out.println(ad);
		String ha = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr[last()]/td[4]")).getText();
		System.out.println(ha);
	

		if (na.equalsIgnoreCase(gr)) {
			System.out.println("entered grade is updated...");
			
		}

		if (ad.equalsIgnoreCase(af)) {
			System.out.println("entered admissionfee is updated...");
			
		}

		if (ha.equalsIgnoreCase(hc)) {
			System.out.println("entered hall charges is updated...");
			
		}

		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("btnYes")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		driver.close();

	}

}
