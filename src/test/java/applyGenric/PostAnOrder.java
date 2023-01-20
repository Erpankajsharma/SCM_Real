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
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;

public class PostAnOrder {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverUtility wd=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		
		int ranNum = ju.getRandomNo();
		
		String brow = fu.readDataFromPropertyFile("browser");
		String urll = fu.readDataFromPropertyFile("url");
		String un = fu.readDataFromPropertyFile("username");
		String pwd = fu.readDataFromPropertyFile("password");
		String lT = fu.readDataFromPropertyFile("loginTypeR");
		
		WebDriver d = null;
		if(brow.equals("firefox"))
		{
			d=new FirefoxDriver();
		}
		else if(brow.equals("chrome"))
		{
			d=new ChromeDriver();
		}
		else if(brow.equals("ie"))
		{
			d=new InternetExplorerDriver();
		}
		else
		{
			d=new ChromeDriver();
		}
		
		wd.implicitWait(d);
		wd.maximizeWindow(d);
		d.get(urll);
		
		//login
		d.findElement(By.id("login:username")).sendKeys(un);
		d.findElement(By.id("login:password")).sendKeys(pwd);
		
		WebElement lType = d.findElement(By.id("login:type"));
		wd.selectByValue(lType, lT);
		
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		d.findElement(By.linkText("New Order")).click();
		
		int count = eu.getLastRowNo("Sheet1");
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testYantra.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		//Map<String, String> map=new HashMap<String, String>();
		for(int i=0; i<4; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			//String result = map.put(key, value);
			d.findElement(By.id(key)).sendKeys(value);
			//System.out.println(key+" "+value);
		}
		
		d.findElement(By.id("btnSubmit")).click();
		
		String orderId = d.findElement(By.xpath("((//tbody)[2]/tr)[last()]/td[5]/../td[1]")).getText();
		System.out.println(orderId);
		
		d.findElement(By.xpath("((//tbody)[2]/tr)[last()]/td[5]")).click();
		
		Thread.sleep(1000);
		String orderno = d.findElement(By.xpath("(//tbody)[2]/tr[1]/td[2]")).getText();
		Thread.sleep(2000);
		if(orderId.equals(orderno))
		{
			System.out.println("Respective new order is displayed successfully in My orders page with passed quantity.");
		}	
	}
}