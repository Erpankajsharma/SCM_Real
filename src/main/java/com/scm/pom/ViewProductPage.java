package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProductPage {
	
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[8]")
	private WebElement editBtn;
	
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[1]")
	private WebElement checkBx;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	
	public ViewProductPage(WebDriver d) {
	PageFactory.initElements(d, this);	

	}
	public WebElement getEditbutton() {
		return editBtn;	
	}
	
	public WebElement getClickdelete() {
		return deleteBtn;
	}
	public WebElement getCheckbox() {
		return checkBx;
	}
	
	//method
	
	public void editbutton() {
		editBtn.click();
	}
	public void delNewlyCreatedProduct() {
		checkBx.click();
		deleteBtn.click();
	}


}
