package manageUnit_Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewOrderDisplayedInAdmin {

	public static void main(String[] args) throws IOException, InterruptedException {
		Random ran=new Random();
		int random = ran.nextInt(500);
		
		//steps to fetch commonData
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String urll = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		//steps to fetch data from excel
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testYantra.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		//String xyz = sh.getRow(1).getCell(0).getStringCellValue()+random;
		
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get(urll);
		//d.findElement(By.xpath("(//span[text()='Open Application'])[17]")).click();
		d.findElement(By.id("login:username")).sendKeys(un);
		d.findElement(By.id("login:password")).sendKeys(pwd);
		
		WebElement lType = d.findElement(By.id("login:type"));
		Select s=new Select(lType);
		s.selectByValue("retailer");
		
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
//		ArrayList<String> al=new ArrayList<String>();
//		al.add("2");
//		al.add("3");
//		al.add("8");
//		al.add("11");
//		al.add("17");
//		al.add("22");
//		al.add("29");
//		al.add("57");
//		al.add("58");
		
		d.findElement(By.linkText("New Order")).click();
		
		System.out.println(sh.getLastRowNum());
		
		/*for(int i=0; i<=sh.getLastRowNum(); i++)
		{
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(value);
			
		}*/
		
		d.findElement(By.id("2")).sendKeys("10");
		d.findElement(By.id("8")).sendKeys("10");
		d.findElement(By.id("29")).sendKeys("20");
		d.findElement(By.id("58")).sendKeys("30");
		Thread.sleep(3000);
		
		d.findElement(By.id("btnSubmit")).click();
	}

}
