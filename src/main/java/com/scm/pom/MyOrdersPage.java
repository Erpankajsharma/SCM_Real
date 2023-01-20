package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage {
	
	@FindBy(id = "cmbFilter")
	private WebElement searchByDD;
	
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[5]/../td[1]")
	private WebElement orderIdGot;
	
	@FindBy(xpath = "((//tbody)[2]/tr)[last()]/td[5]")
	private WebElement NewOrderdetailsLink;
	
	public MyOrdersPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getSearchByDD() {
		return searchByDD;
	}

	public WebElement getNewOrderdetailsLink() {
		return NewOrderdetailsLink;
	}
	
	public WebElement getOrderIdGot() {
		return orderIdGot;
	}
	
	
	
	public void clickOnLastDetailsLink()
	{
		NewOrderdetailsLink.click();
	}
	
	public String expOrderIdGot()
	{
		String expOrderId = orderIdGot.getText();
		return expOrderId;
	}
	

}
