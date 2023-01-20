package com.scm.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.IPathConstants;
import com.scm.GenericUtilities.WebDriverUtility;

public class RetailerLoginPage {

	WebDriverUtility wdu=new WebDriverUtility();
	FileUtility fu=new FileUtility();
	
	@FindBy (id = "login:username")
	private WebElement username;
	
	@FindBy (id = "login:password")
	private WebElement password;
	
	@FindBy (id = "login:type")
	private WebElement loginTDD;
	
	public WebElement getUn() {
		return username;
	}

	public WebElement getPwd() {
		return password;
	}

	public WebElement getLoginTDD() {
		return loginTDD;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}

	@FindBy (xpath = "//input[@class='submit_button']")
	private WebElement lgbtn;
	
	public RetailerLoginPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public void login(String un, String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		wdu.selectByValue(loginTDD, fu.readDataFromPropertyFile("loginTypeM"));
		lgbtn.click();
		
	}
	
	public void loginAsManufac(String un, String pwd) throws IOException
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		wdu.selectByValue(loginTDD, fu.readDataFromPropertyFile("loginTypeM+"));
		lgbtn.click();
	}
	
	public void loginAsAdmin(String un, String pwd) throws IOException
	{
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		wdu.selectByValue(loginTDD, fu.readDataFromPropertyFile("loginTypeA"));
		lgbtn.click();
	}
}


