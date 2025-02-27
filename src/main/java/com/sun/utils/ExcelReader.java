package com.sun.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;


public class ExcelReader 
{
	public static final String FilePath = "src/test/resources/testdata.xlsx";
	public static Object[][] getLoginTestData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream(new File(FilePath));
		
		Workbook workbook =WorkbookFactory.create(file);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++)
		{
			Row row=sheet.getRow(i);
			
			for(int j=0; j<cols; j++)
			{
				data[i-1][j]=row.getCell(j).toString();
				
			}
		}
		
		workbook.close();
		file.close();
		return data;
	}
	
	 
}
