package practice_package;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.GenericUtilities.ExcelUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void readData(String from, String to)
	{
		System.out.println(from+"  ------>  "+to);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eu=new ExcelUtility();
		Object[][] value = eu.readMultipleSetOfData("dataProvider");
		return value;
	}
}
