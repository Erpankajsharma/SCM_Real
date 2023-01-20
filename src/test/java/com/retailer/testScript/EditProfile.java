package com.retailer.testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.WebDriverUtility;
import com.scm.pom.EditProfilePage;
import com.scm.pom.RetailerHomePage;
import com.scm.pom.RetailerLoginPage;

public class EditProfile {

	static WebDriver d;
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		hp.clickEditProfileFeature(d);
		
		EditProfilePage epp=new EditProfilePage(d);
		epp.updateProfile();
		
		wdu.acceptAlert(d);
		
		epp.changePassword();
		
		wdu.acceptAlert(d);
		
		
		
		
	}

}
