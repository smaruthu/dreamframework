package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class A extends Baseclass{
public static void main(String[] args) throws IOException {
	createExcel("data", 0, 0, "java");
	createCell("data", 0, 1, "selenium");
	createRow("data", 1, 0, "12-10-22");
	createCell("data", 1, 1, "aim");
	updateCell("data", 0, 0, "java", "date");
}
}