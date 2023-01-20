package applyGenric;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;

public class VTiger_Setting {

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
		
		d.findElement(By.xpath("(//tbody/tr/td[4]/img)[1]")).click();
		d.findElement(By.linkText("CRM Settings")).click();
		d.findElement(By.partialLinkText("Workflows")).click();
		d.findElement(By.id("new_workflow")).click();
		
		WebElement mlist = d.findElement(By.id("module_list"));
		wd.selectByValue(mlist, "Calendar");
		d.findElement(By.id("new_workflow_popup_save")).click();
		String desc = "abcdefg";
		d.findElement(By.id("save_description")).sendKeys(desc+ranNum);
		d.findElement(By.xpath("//input[@value='ON_MODIFY']")).click();
		
		d.findElement(By.id("save_conditions_add")).click();
		WebElement dd1 = d.findElement(By.id("save_condition_0_fieldname"));
		wd.selectByValue(dd1, "taskpriority");
		d.findElement(By.id("save_submit")).click();
		
		d.findElement(By.partialLinkText("Workflows")).click();
		
		WebElement sd1 = d.findElement(By.id("pick_module"));
		wd.selectByValue(sd1, "Calendar");
		Thread.sleep(5000);
		d.findElement(By.xpath("//td[text()='"+desc+ranNum+"']/../td[3]/a[2]")).click();
		Thread.sleep(2000);
		wd.acceptAlert(d);
		
		
		
		
		
		
	}

}
