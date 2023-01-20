package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manufacturer_EditProductPage {
	
	@FindBy(id="product:name")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@value='Update Product']")
	private WebElement updateProduct;
	
	public Manufacturer_EditProductPage(WebDriver d) {
		PageFactory.initElements(d,this);
	}
	
	public WebElement getUpdateproduct() {
		return updateProduct;
	}
	
	public WebElement getProductname() {
		return productName;
	}
	
	
	public void editProduct() throws InterruptedException {
		productName.clear();
		Thread.sleep(1000);
		productName.sendKeys("veg biriyani");
	}
	
	public void updateproduct() {
		updateProduct.click();	
	}

}
