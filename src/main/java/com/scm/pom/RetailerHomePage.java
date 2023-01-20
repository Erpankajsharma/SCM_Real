package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage {
	
	@FindBy(linkText = "Home")
	private WebElement homeFeature;
	
	@FindBy(linkText = "Products")
	private WebElement ProdListPage;
	
	@FindBy(linkText = "My Orders")
	private WebElement MyOrdersListPage;
	
	@FindBy(linkText = "My Invoices")
	private WebElement MyInvoicesListPage;
	
	@FindBy(linkText = "New Order")
	private WebElement NewOrderFeature;
	
	@FindBy(linkText = "Edit Profile")
	private WebElement EditProfileFeature;
	
	@FindBy(xpath = "//input[@value='Log out']")
	private WebElement lgout;
	
	public RetailerHomePage (WebDriver d)
	{
		PageFactory.initElements(d, this);
	}

	public WebElement getHomeFeature() {
		return homeFeature;
	}

	public WebElement getProdListPage() {
		return ProdListPage;
	}

	public WebElement getMyOrdersListPage() {
		return MyOrdersListPage;
	}

	public WebElement getMyInvoicesListPage() {
		return MyInvoicesListPage;
	}

	public WebElement getLgout() {
		return lgout;
	}

	public WebElement getNewOrderFeature() {
		return NewOrderFeature;
	}

	public WebElement getEditProfileFeature() {
		return EditProfileFeature;
	}
	
	//
	
	public void clickHomeFeature(WebDriver d)
	{
		homeFeature.click();
	}
	
	public void clickProductsFeature(WebDriver d)
	{
		ProdListPage.click();
	}
	
	public void clickMyOrderFeature(WebDriver d)
	{
		MyOrdersListPage.click();
	}
	
	public void clickMyInvoiceFeature(WebDriver d)
	{
		MyInvoicesListPage.click();
	}
	
	public void clickNewOrderFeature(WebDriver d)
	{
		NewOrderFeature.click();
	}
	
	public void clickEditProfileFeature(WebDriver d)
	{
		EditProfileFeature.click();
	}
	
	public void logOut(WebDriver d)
	{
		lgout.click();
	}

}
