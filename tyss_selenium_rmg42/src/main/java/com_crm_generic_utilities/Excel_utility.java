package com_crm_generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	
	/*
	 * this method is used to fetch data from excel 
	 * parameter sheetname 
	 * parameter rownum
	 * parameter cellnum
	 * return
	 * throws throwable
	 * author manjunath
	 */
	
	public String getDataFromExcel(String sheetname,int Rownum,int cellnum) throws Throwable 
	{
		FileInputStream fis1=new FileInputStream("Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet(sheetname);
		Row row = sh.getRow(Rownum);
		Cell cel = row.getCell(cellnum);
		String data = cel.getStringCellValue();
		return data;
		
	}

}
