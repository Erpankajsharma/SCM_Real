package com.scm.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.scm.pom.RetailerHomePage;
import com.scm.pom.RetailerLoginPage;

public class BaseClass {
	
	public WebDriver d;
	public static WebDriver sdriver;
	public WebDriverUtility wdu=new WebDriverUtility();
	public ExcelUtility eu=new ExcelUtility();
	public DataBaseUtility dbu=new DataBaseUtility();
	public FileUtility fu=new FileUtility();
	public JavaUtility ju=new JavaUtility();
	
	@BeforeSuite(groups = {"smoke", "regression"})
	public void configDB()
	{
		//dbu.connectToDB();
		System.out.println("---connect to DB---");
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke", "regression"})
	
	public void configBC() throws IOException
	//public void configBC(String BROWSER) throws IOException
	{
		String BROWSER = fu.readDataFromPropertyFile("browser");
		
		String URL = fu.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			d=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		sdriver=d;
		
		wdu.maximizeWindow(d);
		wdu.implicitWait(d);
		d.get(URL);
		
		System.out.println("---Launch the browser---");
	}
	
	@BeforeMethod(groups = {"smoke", "regression"})
	public void configBM() throws IOException, InterruptedException
	{
		String USERNAME = fu.readDataFromPropertyFile("username");
		String PASSWORD = fu.readDataFromPropertyFile("passwordM");
		//String LOGINTYPE_R = fu.readDataFromPropertyFile("loginTypeR");
		//String LOGINTYPE_M = fu.readDataFromPropertyFile("loginTypeM");
		
		Thread.sleep(2000);
		RetailerLoginPage lp=new RetailerLoginPage(d);
		lp.login(USERNAME, PASSWORD);
		
		
		
//		lp.loginAsManufac(USERNAME, PASSWORD);
//		
//		lp.loginAsAdmin(USERNAME, PASSWORD);
//		
		System.out.println("---Login to App---");
	}
	
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void configAM()
	{
		RetailerHomePage rhp=new RetailerHomePage(d);
		rhp.logOut(d);
		System.out.println("---Logout from the App---");
	}
	
	@AfterClass(groups = {"smoke", "regression"})
	public void configAC()
	{
		d.quit();
		System.out.println("---Close the browser---");
	}
	
	@AfterSuite(groups = {"smoke", "regression"})
	public void disconnectDB() throws SQLException
	{
		//dbu.closeDB();
		System.out.println("---Close the DB---");
	}

}
