package com.qa.tutorialsninja.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtil {
	private static Workbook book;
	private static Sheet sheet;
	public static String Registration_Sheet_Path = "./src/main/java/com/qa/tutorialsninja/testdata/registration.xlsx";
	
	public static Object[][] getTestData(String sheetName) {
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(Registration_Sheet_Path);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
			 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					
					data[i][j] = sheet.getRow(i+1).getCell(j);
					
				}
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return data;
		
		
	}
	

}
