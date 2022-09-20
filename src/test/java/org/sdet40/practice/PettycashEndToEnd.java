package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PettycashEndToEnd {

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
		driver.findElement(By.xpath("//span[text()='Petty Cash']")).click();
		driver.findElement(By.xpath("//a[@onclick='showModal()']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("textDesc_1")).sendKeys("books");
		driver.findElement(By.id("textAmount_1")).sendKeys("1000");
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//option[@value='100']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		driver.close();

	}

}
