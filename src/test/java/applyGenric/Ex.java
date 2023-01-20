package applyGenric;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.scm.GenericUtilities.IPathConstants;

public class Ex {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testYantra.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		//Map<String, String> map=new HashMap<String, String>();
		for(int i=0; i<count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			//String result = map.put(key, value);
			System.out.println(key+" "+value);
		}
	}
		
	
}

