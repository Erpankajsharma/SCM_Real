package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.GenericUtilities.JavaUtility;

public class EditProfilePage {

	@FindBy(id = "retailer:phone")
	private WebElement phonetbx;
	
	@FindBy(id = "retailer:email")
	private WebElement emailtbx;
	
	@FindBy(id = "retailer:address")
	private WebElement addresstbx;
	
	@FindBy(xpath = "//input[@value='Change Password']")
	private WebElement changePwdBtn;
	
	@FindBy(xpath = "//input[@value='Update Profile']")
	private WebElement updateProfileBtn;
	
	@FindBy(id = "oldPassword")
	private WebElement oldPassTbx;
	
	@FindBy(id = "newPassword")
	private WebElement newPassTbx;
	
	@FindBy(id = "confirmPassword")
	private WebElement confPassTbx;
	
	
	
	public EditProfilePage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getPhonetbx() {
		return phonetbx;
	}

	public WebElement getEmailtbx() {
		return emailtbx;
	}

	public WebElement getAddresstbx() {
		return addresstbx;
	}

	public WebElement getChangePwdBtn() {
		return changePwdBtn;
	}

	public WebElement getUpdateProfileBtn() {
		return updateProfileBtn;
	}
	
	public void clearPhoneTbx()
	{
		phonetbx.clear();
	}
	
	public void clearEmailTbx()
	{
		emailtbx.clear();
	}
	
	public void clearAddressTbx()
	{
		addresstbx.clear();
	}
	
	JavaUtility ju=new JavaUtility();
	
	
	public void updateProfile() throws InterruptedException
	{
		int random = ju.getRandomNo();
		clearPhoneTbx();
		Thread.sleep(3000);
		clearEmailTbx();
		Thread.sleep(3000);
		clearAddressTbx();
		Thread.sleep(3000);
		
		 String ph = "8521712345";
		phonetbx.sendKeys(ph);
		emailtbx.sendKeys("pankaj@gmail.com");
		addresstbx.sendKeys("Siwan");
		updateProfileBtn.click();
	}
	
	public void changePassword()
	{
		changePwdBtn.click();
		oldPassTbx.sendKeys("admin123");
		newPassTbx.sendKeys("admin1234");
		confPassTbx.sendKeys("admin1234");
		changePwdBtn.click();
		
	}
	
	
	
	
}
