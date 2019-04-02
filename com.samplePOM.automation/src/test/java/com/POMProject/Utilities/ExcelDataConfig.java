package com.POMProject.Utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	ConfigDataProvider config=new ConfigDataProvider();
	static XSSFWorkbook wb;
	public ExcelDataConfig() 
	{
	File src=new File(config.getExcelpath());
	
	try {
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
	}
	
	public  String getStringData(String sheetName,int row,int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row,int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	public String getStringData(int sheetNum,int row,int col) {
		return wb.getSheetAt(sheetNum).getRow(row).getCell(col).getStringCellValue();
	}
}
