package com.retailer.testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.MyOrdersPage;
import com.scm.pom.OrderDetailsPage;
import com.scm.pom.OrderItemsPage;
import com.scm.pom.RetailerHomePage;
import com.scm.pom.RetailerLoginPage;

public class NewOrderModuleVerifyNOTest {

	static WebDriver d;
	public static void main(String[] args) throws IOException {
		
		d=new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.maximizeWindow(d);
		wdu.implicitWait(d);
		
		FileUtility fu=new FileUtility();
		d.get(fu.readDataFromPropertyFile("url"));
		RetailerLoginPage lp=new RetailerLoginPage(d);
		lp.login(fu.readDataFromPropertyFile("username"), fu.readDataFromPropertyFile("password"));
		
		RetailerHomePage hp=new RetailerHomePage(d);
		hp.clickNewOrderFeature(d);
		
		
		ExcelUtility eu=new ExcelUtility();
		OrderItemsPage oip=new OrderItemsPage(d);
		oip.orderIte(eu);
		
		MyOrdersPage mop=new MyOrdersPage(d);
		mop.clickOnLastDetailsLink();
		
		OrderDetailsPage odp=new OrderDetailsPage(d);
		if(mop.expOrderIdGot().equals(odp.NewOrderNo()))
		{
			System.out.println("Newly created order is successfully displayed in My orders page.");
		}
		
		
		
		
		
		
	}

}
