package com.scm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturerHomePage {
	
	@FindBy(linkText = "Add Products")
	private WebElement addproduct;
	
	@FindBy(linkText = "Products")
	private WebElement productListFeature;

	public ManufacturerHomePage (WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public WebElement getAddproduct() {
		return addproduct;
		}
	
	public WebElement getProductlistfeature() {
		return productListFeature;
	}
	
	public void addProducts() {
		addproduct.click();
	}
	
	public void productListFeature() {
		productListFeature.click();
	}

}
