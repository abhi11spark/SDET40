package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomEndToEnd {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
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
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//a[@href='class_room.php']")).click();
		driver.findElement(By.id("name")).sendKeys("GC25");
		driver.findElement(By.id("student_count")).sendKeys("40");
		Thread.sleep(4000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[text()='Edit'])[7]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("student_count1")).clear();
		driver.findElement(By.id("student_count1")).sendKeys("50");
		driver.findElement(By.id("btnSubmit1")).click();
		Thread.sleep(4000);
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
