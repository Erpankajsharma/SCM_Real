package com.retailer.testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.OrderItemsPage;
import com.scm.pom.RetailerHomePage;
import com.scm.pom.RetailerLoginPage;

public class PostAnOrderTest {

	static WebDriver d;
	public static void main(String[] args) throws Throwable {
		
		d=new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.maximizeWindow(d);
		wdu.implicitWait(d);
		
		FileUtility fu=new FileUtility();
		String ul = fu.readDataFromPropertyFile("url");
		String un = fu.readDataFromPropertyFile("username");
		String pwd = fu.readDataFromPropertyFile("password");
		//String lT = fu.readDataFromPropertyFile("loginTypeR");
		
		d.get(ul);
		
		RetailerLoginPage lp=new RetailerLoginPage(d);
		lp.login(un, pwd);
		
		RetailerHomePage hp=new RetailerHomePage(d);
		hp.clickNewOrderFeature(d);
		
		
		ExcelUtility eu=new ExcelUtility();
		OrderItemsPage oip=new OrderItemsPage(d);
		oip.orderIte(eu);
		
//		for(int i=0; i<=eu.getLastRowNo("orderItemPage"); i++)
//		{
//			String data = oip.createAnOrder();
//			System.out.println(data);
//		
		//	hp.logOut(d);
		
		
		
		

	}

}
