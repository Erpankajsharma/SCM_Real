package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass {

	@BeforeClass
	public void openBrowser()
	{
		System.out.println("beforeClass / openBrowser");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("beforeMethod / loginApp");
	}
	
	@Test(priority = 1, invocationCount = 2)
	public void postAnOrder()
	{
		System.out.println("Order posted");
	}
	
	@Test(dependsOnMethods = "postAnOrder")
	public void verifyThePost()
	{
		System.out.println("Test / verified");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("afterMethod / logoutApp");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("afterClass / closedBrowser");
	}
	
	@BeforeTest
	public void beforTest()
	{
		System.out.println("beforetest");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("aftertest");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuite");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("aftersuite");
	}
	
	
}
