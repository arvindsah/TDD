package com.application.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	static String PATH_TO_EXCEL_DATA_FILE = ".\\src\\main\\java\\com\\application\\testdata\\testDataSheet.xlsx";
	
	
	
	public static Object[][] readDataFromExcelSheet(String sheetName){
		 Object[][] obj = null;
	try {
		
		FileInputStream fileInputStream = new FileInputStream(new File(PATH_TO_EXCEL_DATA_FILE));
		 Workbook wbf= (Workbook) WorkbookFactory.create(fileInputStream);
		 Sheet sheet= wbf.getSheet(sheetName);
		
		  obj= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		 for(int i=0; i<sheet.getLastRowNum();i++) {
			
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				obj[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return obj;
	} catch (FileNotFoundException e) {
		System.err.println("file not found");
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return obj;
	}
	
	
	
	public static Object[][] readDataFromExcelSheetToCompare(String sheetName){
		 Object[][] obj = null;
	try {
		
		FileInputStream fileInputStream = new FileInputStream(new File(PATH_TO_EXCEL_DATA_FILE));
		 Workbook wbf= (Workbook) WorkbookFactory.create(fileInputStream);
		 Sheet sheet= wbf.getSheet(sheetName);
		
		  obj= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		 for(int i=0; i<sheet.getLastRowNum();i++) {
			
			
				obj[i][0]=sheet.getRow(i+1).getCell(0).toString();
			
		}
		matchTheColumnNames(obj, wbf);
		return obj;
	} catch (FileNotFoundException e) {
		System.err.println("file not found");
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return obj;
	}



	private static void matchTheColumnNames(Object[][] obj, Workbook wbf) {
		 Sheet sheet= wbf.getSheet("output");
			
		 int count=0;
		 Object[][] obj2= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		 for(int x=0; x<obj.length;x++) 
		 {
			 System.out.println("first sheet row names  --  " + obj[x][0].toString());
		
			 for(int i=0; i<sheet.getRow(0).getLastCellNum();i++)
		 {
			 System.out.println("second sheet column names  --  " + sheet.getRow(0).getCell(i).toString());
			
			
			if(obj[x][0].toString().equals(sheet.getRow(0).getCell(i).toString()))
			{	count++;		
				System.out.println("row matched with the column row name "
						+ "which is matched in the sheet output sheet------" + obj[x][0].toString() +"   columgn ----"+ sheet.getRow(0).getCell(i).toString());
			}
			
		}
		
	}
		 System.out.println("total rows mathed in the column of sheet-----------------------**********" + count);
	}
	
}
