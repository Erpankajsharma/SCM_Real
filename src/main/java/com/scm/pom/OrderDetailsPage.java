package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
	
	@FindBy(xpath = "(//tbody)[2]/tr[1]/td[2]")
	private WebElement orderNo;
	
	public OrderDetailsPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getOrderNo() {
		return orderNo;
	}
	
	public String NewOrderNo()
	{
		String actualOrderId = orderNo.getText();
		return actualOrderId;
	}
	
	

}
