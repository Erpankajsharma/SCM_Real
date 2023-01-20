package com.scm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * this method is used to fetch the data from excel sheet.
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetName, int rowNo, int columnNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(columnNo);
		String value = cel.toString();
		return value;
	}
	
	public void writeDataIntoExcel(String sheetName, int rowNo, int columnNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.createRow(rowNo);
		Cell cel = ro.createCell(columnNo);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.EXCELPATH);
		wb.write(fos);
	}
	
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	public Map<String, String> getList(String sheetName, int keyCell, int valueCell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		Map<String, String> map=new HashMap<String, String>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/*public String readDataFromExcel(String sheetName, int rowNo, int columnNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(columnNo);
		String value = cel.getStringCellValue();
		return value;
	}*/
	
	public Object[][] readMultipleSetOfData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object ob[][] = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				ob[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return ob;	
	}
}


