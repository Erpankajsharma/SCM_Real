package com.retailer.testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.RetailerLoginPage;

public class LoginTest {
	
	static WebDriver d;
	public static void main(String[] args) throws IOException {
		
		d = new ChromeDriver();
		FileUtility fu=new FileUtility();
		WebDriverUtility wdu=new WebDriverUtility();
		String ul = fu.readDataFromPropertyFile("url");
		String un = fu.readDataFromPropertyFile("username");
		String pwd = fu.readDataFromPropertyFile("password");
		//String lT = fu.readDataFromPropertyFile("loginTypeR");
		
		wdu.maximizeWindow(d);
		d.get(ul);
		wdu.implicitWait(d);
		
		
		RetailerLoginPage lp=new RetailerLoginPage(d);
		lp.login(un, pwd);
		
	}

}
