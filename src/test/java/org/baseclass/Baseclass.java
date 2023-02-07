package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void lanchUrl(String url) {
		driver.get(url);
	}

	public static String title() {
		String t = driver.getTitle();
		return t;
	}
	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}
public static void closeBrowser() {
	driver.close();

}
	public static void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\screenshot\\" + fileName + ".png");
		FileUtils.copyFile(src, dest);
	}

	public static void passvalue(WebElement element,String input) {
		element.sendKeys(input);

	}
	public static void elementClick(WebElement element) {
		element.click();

	}

	public static void frame() throws InterruptedException {
		WebElement f1 = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		driver.switchTo().frame(f1);
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

	}

	public static void noFrames() {
		List<WebElement> li = driver.findElements(By.tagName("iframes"));
		System.out.println(li);
	}

	public static String excelRead(String sheetName, int row, int cell) throws IOException {
		File f = new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\excel\\testdata.xlsx");
		// file read
		FileInputStream fis = new FileInputStream(f);
		// xlsx workbook read
		Workbook w = new XSSFWorkbook(fis);
		// get the sheet from workbook
		Sheet s1 = w.getSheet(sheetName);

		// get the no of rows
		int noOfRows = s1.getPhysicalNumberOfRows();
		System.out.println("no of rows " + noOfRows);

		Row r = s1.getRow(row);

		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		System.out.println(c + "--->" + cellType);
String value;
		if (cellType == 1) {
			value = c.getStringCellValue();
			
		} else if (DateUtil .isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();// SYSTEM FORMAT
			SimpleDateFormat sl = new SimpleDateFormat("dd-MM-YY");// USER FORMAT
			value = sl.format(d);
			

		} else {
			double nc = c.getNumericCellValue();
			long l = (long) nc;
			value = String.valueOf(l);
		}
		return value;
		
	}
	public static void createExcel(String sheetName,int row,int cell,String value) throws IOException {
		
		File f =new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\excel\\newexcel.xlsx");
		
		Workbook w=new XSSFWorkbook();
		Sheet s = w.createSheet(sheetName);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("end");
		
	}
	public static void createCell(String sheetName,int row,int cell,String value) throws IOException {

		File f =new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\excel\\newexcel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		//get sheet from workbook
		Sheet s = w.getSheet(sheetName);
		//get row from sheet
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		
		FileOutputStream fos =new FileOutputStream(f);
		w.write(fos);
		System.out.println("end");
		
	}
	public static void createRow(String sheetName,int row,int cell,String value) throws IOException {
		File f =new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\excel\\newexcel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		//get sheet from workbook
		Sheet s = w.getSheet(sheetName);
		//create row
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
c.setCellValue(value);
		
		FileOutputStream fos =new FileOutputStream(f);
		w.write(fos);
		System.out.println("end");
		
		
	}
	public static void updateCell(String sheetName,int row,int cell,String oldvalue,String newvalue) throws IOException {
		File f =new File("C:\\Users\\PC\\eclipse-workspace\\Goal\\excel\\newexcel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		//get sheet from workbook
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();
		if (value.equals(oldvalue)) {
			c.setCellValue(newvalue);
		}
		
		FileOutputStream fos =new FileOutputStream(f);
		w.write(fos);
		System.out.println("end");
		System.out.println("welcome");
		System.out.println("end");
		
	}
}
