package addProducts_Manufacturer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddProducts {

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
		Sheet sh = wb.getSheet("Sheet2");
		//String textBoxData = sh.getRow(1).getCell(0).getStringCellValue()+random;

		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get(urll);
		
		d.findElement(By.id("login:username")).sendKeys(un);
		d.findElement(By.id("login:password")).sendKeys(pwd);
		
		WebElement lType = d.findElement(By.id("login:type"));
		Select sl=new Select(lType);
		sl.selectByValue("manufacturer");
		
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		d.findElement(By.xpath("//a[text()='Add Products']")).click();
		
		ArrayList<String> al=new ArrayList<String>();
		al.add("product:name");
		al.add("product:price");
		al.add("product:description");
		
		for(int i=0; i<=sh.getLastRowNum()-1; i++)
		{
			Thread.sleep(1000);
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			d.findElement(By.id(al.get(i))).sendKeys(value);
		}
		
		WebElement pUnit = d.findElement(By.id("product:unit"));
		Select s=new Select(pUnit);
		s.selectByValue("2");
		
		WebElement pCategory = d.findElement(By.id("product:category"));
		Thread.sleep(1000);
		Select s1=new Select(pCategory);
		s1.selectByValue("13");
		
		d.findElement(By.name("rdbStock")).click();
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		Alert a = d.switchTo().alert();
		a.accept();
		
		String expectedPName = sh.getRow(0).getCell(1).getStringCellValue();
		
		d.findElement(By.linkText("Products")).click();
		String pName = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
		
		if(pName.equals(expectedPName))
		{
			System.out.println("The specific product has been successfuly added.");
		}
		
		d.findElement(By.xpath("((//tbody)[2]/tr)[last()]/td[8]")).click();
		Thread.sleep(2000);
		d.findElement(By.id("product:name")).clear();
		d.findElement(By.id("product:name")).sendKeys(expectedPName+""+random);
		
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			Thread.sleep(1000);
			String updateValue = sh.getRow(i).getCell(1).getStringCellValue();
			d.findElement(By.id(al.get(i))).clear();
			d.findElement(By.id(al.get(i))).sendKeys(updateValue+""+random);	
		}
		d.findElement(By.xpath("//input[@type='radio']")).click();
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(1000);
		Alert a1 = d.switchTo().alert();
		a1.accept();
		
		d.findElement(By.linkText("Products")).click();
		
		String updatedProductName = sh.getRow(0).getCell(1).getStringCellValue();
		String updatedName = updatedProductName+""+random;
		
		String actualUpdatedName = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
		if(updatedName.equals(actualUpdatedName))
		{
			System.out.println("updated product is successfully verified.");
		}
		
		d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[1]")).click();
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		a1.accept();
		String afterDeletedLastPName = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
		if(updatedName.equals(afterDeletedLastPName)) 
		{
			System.out.println("Item is not deleted.");
		}
		else
		{
			System.out.println("Item is successfully deleted.");
		}
		d.close();
		
		
		
		
		

	}

}
