package applyGenric;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;

public class AddUpdateDeleteUnitGen {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverUtility wd=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		
		int ranNum = ju.getRandomNo();
		
		String brow = fu.readDataFromPropertyFile("browser");
		String un = fu.readDataFromPropertyFile("username");
		String urll = fu.readDataFromPropertyFile("url");
		String pwd = fu.readDataFromPropertyFile("passwordA");
		String lT = fu.readDataFromPropertyFile("loginTypeA");
		
		WebDriver d = null;
		if(brow.equals("firefox"))
		{
			d = new FirefoxDriver();
		}
		else if(brow.equals("chrome"))
		{
			d = new ChromeDriver();
		}
		
		wd.implicitWait(d);
		wd.maximizeWindow(d);
		d.get(urll);
		
		d.findElement(By.id("login:username")).sendKeys(un);
		d.findElement(By.id("login:password")).sendKeys(pwd);
		WebElement lTy = d.findElement(By.id("login:type"));
		wd.selectByValue(lTy, lT);
		d.findElement(By.xpath("//input[@type='submit']")).click();
		
		d.findElement(By.linkText("Manage Unit")).click();
		d.findElement(By.xpath("//input[@value='+ Add Unit']")).click();
		String unitNamev = "quarter";
		d.findElement(By.id("unitName")).sendKeys(unitNamev);
		String desc = "one-fourth of the product";
		d.findElement(By.id("unitDetails")).sendKeys(desc);
		d.findElement(By.xpath("//input[@value='Add Unit']")).click();
		wd.acceptAlert(d);
		
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
		
		String updatedDesc = desc+""+ranNum;
		Thread.sleep(1000);
		d.findElement(By.id("unitDetails")).clear();
		d.findElement(By.id("unitDetails")).sendKeys(updatedDesc);
		d.findElement(By.xpath("//input[@value='Update Unit']")).click();
		wd.acceptAlert(d);
		
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
		wd.acceptAlert(d);
		
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
