package com.manufacturer.testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.ManufacturerHomePage;
import com.scm.pom.Manufacturer_AddProductPage;
import com.scm.pom.RetailerLoginPage;

public class AddProduct {
	
	static WebDriver d;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		d=new ChromeDriver();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.maximizeWindow(d);
		wdu.implicitWait(d);
		
		FileUtility fu=new FileUtility();
		d.get(fu.readDataFromPropertyFile("url"));
		RetailerLoginPage lp=new RetailerLoginPage(d);
		lp.loginAsManufac(fu.readDataFromPropertyFile("username"), fu.readDataFromPropertyFile("passwordM"));
		
		ManufacturerHomePage mhp=new ManufacturerHomePage(d);
		mhp.addProducts();
		
		Manufacturer_AddProductPage mapp=new Manufacturer_AddProductPage(d);
		mapp.addproductsViaManuf();
		
		wdu.acceptAlert(d);
		
		mhp.productListFeature();
		
		
		
		
	}

}
