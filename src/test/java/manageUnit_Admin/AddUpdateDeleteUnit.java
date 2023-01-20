package manageUnit_Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddUpdateDeleteUnit {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		Random r=new Random();
		int random = r.nextInt(100);
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String urll = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\testYantra.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("");
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(urll);
		
		d.findElement(By.id("login:username")).sendKeys(un);
		d.findElement(By.id("login:password")).sendKeys(pwd);
		
		WebElement lType = d.findElement(By.id("login:type"));
		Select s=new Select(lType);
		s.selectByValue("admin");
		
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		d.findElement(By.linkText("Manage Unit")).click();
		d.findElement(By.xpath("//input[@value='+ Add Unit']")).click();
		String unitNamev = "quarter";
		d.findElement(By.id("unitName")).sendKeys(unitNamev);
		String desc = "one-fourth of the product";
		d.findElement(By.id("unitDetails")).sendKeys(desc);
		d.findElement(By.xpath("//input[@value='Add Unit']")).click();
		
		Alert a = d.switchTo().alert();
		a.accept();
		
		d.findElement(By.linkText("Manage Unit")).click();
		String unitName = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
		
		if(unitNamev.equals(unitName))
		{
			System.out.println("particular unit is successfully added.");
		}
		else
		{
			System.out.println("particular unit is not added.");
		}
		
		d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[5]")).click();
		
		
		//d.findElement(By.id("unitName")).clear();
		String updatedDesc = desc+""+random;
		Thread.sleep(1000);
		d.findElement(By.id("unitDetails")).clear();
		d.findElement(By.id("unitDetails")).sendKeys(updatedDesc);
		d.findElement(By.xpath("//input[@value='Update Unit']")).click();
		
		a.accept();
		
		String updatedDescInViewUnitP = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[4]")).getText();
		if(updatedDesc.equals(updatedDescInViewUnitP))
		{
			System.out.println("unit is successfully updated.");
		}
		else
		{
			System.out.println("unit is not updated.");
		}
		d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[1]")).click();
		d.findElement(By.xpath("//input[@value='Delete']")).click();
		
		a.accept();
		
		String unitNameAfterDeleted = d.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
		if(unitName.equals(unitNameAfterDeleted))
		{
			System.out.println("item is not deleted");
		}
		else
		{
			System.out.println("item is deleted");
		}
		
		d.close();
		
	}

}
