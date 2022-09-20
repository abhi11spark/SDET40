package org.sdet40.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubjectEndToEndPSMS {

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Subject']"))));
		
		driver.findElement(By.xpath("//span[text()='Subject']")).click();
		String name = wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		WebElement dropdown = driver.findElement(By.name("example1_length"));
		Select s = new Select(dropdown);
		s.selectByVisibleText("100");
		Thread.sleep(2000);

		WebElement Nextbtn = driver.findElement(By.xpath("//a[text()='Next']"));
		Point loc = Nextbtn.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

		List<WebElement> subjectList = driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> subjectNameList = new ArrayList<WebElement>();

		for (WebElement A : subjectList) {
			String headerName = A.getText();
			System.out.println(headerName);
			if (headerName.equals("Subject")) {
				subjectNameList = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[2]"));
				for (WebElement d : subjectNameList) {
					System.out.println(d.getText());
				}
			}
			for (WebElement subjectName : subjectNameList) {
				String name1 = subjectName.getText();
				System.out.println(subjectName.getText());
				if (name.equals("Hero")) {
					System.out.println("Subject name is added");
					break;
				}

			}

			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			driver.findElement(By.id("btnYes")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[4]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[text()='Sign out']")).click();
			driver.close();
		}
	}

}
