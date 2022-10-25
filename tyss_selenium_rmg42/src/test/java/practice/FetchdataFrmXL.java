package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchdataFrmXL {

	public static void main(String[] args) throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		FileInputStream fis=new FileInputStream("Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet she = book.getSheet("Sheet1");
		Row row = she.getRow(0);
		Cell cel = row.getCell(0);
		String value = cel.getStringCellValue();
		
		//double value1 = cel.getNumericCellValue(); if you want to fetch numeric value
		//String value3 = cel.toString(); if you want to fetch any value
		
		System.out.println(value);
	

	}

}
