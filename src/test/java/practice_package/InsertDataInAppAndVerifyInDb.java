package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataInAppAndVerifyInDb {
	
	public static void main(String[] args) throws SQLException {
		Random random=new Random();
		int ranNum = random.nextInt(100);
		WebDriver driver;
		String project_name = "Zoo_view";
		Connection con = null;
		Statement stat = null;
		try
		{
			//driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://rmgtestingserver:8084/");
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.name("password")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			driver.findElement(By.linkText("Projects")).click();
			driver.findElement(By.xpath("//span[text()='Create Project']")).click();
			driver.findElement(By.name("projectName")).sendKeys("SCM_1111");
			driver.findElement(By.name("createdBy")).sendKeys("Pankaj");
			
			WebElement lB = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s=new Select(lB);
			s.selectByValue("Created");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			stat = con.createStatement();
			String query = "select * from project";
			ResultSet result = stat.executeQuery(query);
			boolean flag = false;
			while(result.next())
			{
				String actualProject = result.getString(4);
				System.out.println(actualProject);
				if(actualProject.equals(project_name))
				{
					flag = true;
				
					break;
				}
			}
			if(flag)
			{
				System.out.println("project is visible in DB.");
			}
			else
			{
				System.out.println("Project is not created.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
			System.out.println("DB is closed.");
		}
		
		
		

	}

}
