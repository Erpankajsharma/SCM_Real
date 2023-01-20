package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.GenericUtilities.WebDriverUtility;

public class Manufacturer_AddProductPage {
	
	WebDriverUtility wdu=new WebDriverUtility();
	
	@FindBy(id="product:name")
	private WebElement productname;
	
	@FindBy(id="product:price")
	private WebElement productprice;
	
	@FindBy(id="product:description")
	private WebElement productdescription;

	@FindBy(id="product:unit")
	private WebElement selectunit;
	
	@FindBy(id="product:category")
	private WebElement selectcategory;
	
	@FindBy(xpath = "(//input[@name='rdbStock'])[1]")
	private WebElement enableStock;
	
	@FindBy(xpath = "//input[@value='Add Product']")
	private WebElement clickOnAddProduct;
	

	public Manufacturer_AddProductPage (WebDriver d) {
		PageFactory.initElements(d, this);
	
	}

	

//	public WebDriverUtility getWdu() {
//		return wdu;
//	}
	
	public WebElement getEnable() {
		return enableStock;
		}

	public WebElement getClickonaddproduct() {
		return clickOnAddProduct;
		}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductprice() {
		return productprice;
	}

	public WebElement getProductdescription() {
		return productdescription;
	}

	public WebElement getSelectunit() {
		return selectunit;
	}

	public WebElement getSelectcategory() {
		return selectcategory;
	}
	
//	public void clickSelectUnit()
//	{
//		wdu.select(" KG ", selectunit);
//	}
	
	public void addproductsViaManuf() throws InterruptedException {
		productname.sendKeys("veg puff");
		productprice.sendKeys("5");
		productdescription.sendKeys("order successfully");
		Thread.sleep(2000);
		//clickSelectUnit();
		wdu.selectByVisibleText(selectunit, "KG");
		Thread.sleep(2000);
		wdu.selectByValue(selectcategory, "3");
		enableStock.click();
		clickOnAddProduct.click();
	}


}
