package applyGenric;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.IPathConstants;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;

public class VTiger_Product {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverUtility wd=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		
		int ranNum = ju.getRandomNo();
		
		String brow = fu.readDataFromPropertyFile("browser");
		String un = fu.readDataFromPropertyFile("usernameVT");
		String urll = fu.readDataFromPropertyFile("urlVT");
		String pwd = fu.readDataFromPropertyFile("passwordVT");
		
		
		WebDriver d = null;
		if(brow.equals("firefox"))
		{
			d = new FirefoxDriver();
		}
		else if(brow.equals("chrome"))
		{
			d = new ChromeDriver();
		}
		
		wd.maximizeWindow(d);
		wd.implicitWait(d);
		d.get(urll);
		d.findElement(By.name("user_name")).sendKeys(un);
		d.findElement(By.name("user_password")).sendKeys(pwd);
		d.findElement(By.id("submitButton")).click();
		
		//after login
		
		d.findElement(By.linkText("Products")).click();
		d.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		int count = eu.getLastRowNo("vTiger");
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("vTiger");
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			Thread.sleep(500);
			d.findElement(By.name(key)).sendKeys(value);
		}
		
		
		d.findElement(By.id("jscal_trigger_sales_start_date")).click();
		WebElement yearbtn = d.findElement(By.xpath("//thead/tr[2]/td[1]"));
		for(int i=1; i<=2; i++)
		{
			yearbtn.click();
		}
		
		for(int i=1; i<=2; i++)
		{
			
		}
		
	
		
		
		
	}

}
