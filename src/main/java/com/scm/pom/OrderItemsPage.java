package com.scm.pom;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scm.GenericUtilities.ExcelUtility;

public class OrderItemsPage {
	
	ExcelUtility eu=new ExcelUtility();
	
	/*@FindBy(id = "1")
	private WebElement itemNo1;
	
	@FindBy(id = "5")
	private WebElement itemNo5;
	
	@FindBy(id = "10")
	private WebElement itemNo10;
	
	@FindBy(id = "15")
	private WebElement itemNo15;
	
	@FindBy(id = "20")
	private WebElement itemNo20;*/
	
	@FindBy(id = "btnSubmit")
	private WebElement postOrderBtn;
	
	@FindAll({@FindBy(id = "1"),@FindBy(id = "5"),@FindBy(id = "10"),@FindBy(id = "20"),@FindBy(id = "25")})
	private List<WebElement> items;
	
	public OrderItemsPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
	}
	
	public void orderIte(ExcelUtility eu) throws EncryptedDocumentException, IOException {
		
		for (int i = 0; i < items.size(); i++) {
			
			String itemNo = items.get(i).getAttribute("id");
			//System.out.println(itemNo);
			int iteNo = Integer.parseInt(itemNo);
			//System.out.println(itemNo);
			for (int j = 0; j <= eu.getLastRowNo("orderItemPage"); j++) {
				
			
			String item = eu.readDataFromExcel("orderItemPage", j, 3);
			int ijj = (int)Double.parseDouble(item);
			//int ik = (int)ijj;
			//System.out.println(item);
			if(iteNo==ijj) {
				String qty = eu.readDataFromExcel("orderItemPage", j, 1);
					
				items.get(i).sendKeys(qty);
			}
			
		}}
		postOrderBtn.click();
	}

/*	public WebElement getItemNo1() {
		return itemNo1;
	}

	public WebElement getItemNo5() {
		return itemNo5;
	}

	public WebElement getItemNo10() {
		return itemNo10;
	}

	public WebElement getItemNo15() {
		return itemNo15;
	}

	public WebElement getItemNo20() {
		return itemNo20;
	}*/

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}
	
	
	
	public void createAnOrder()
	{
//		String we = null;
//		String quantity = null;
//		//Map<String, String> data = eu.getList("orderItemPage", 0, 1);
//		for(int i=0; i<=eu.getLastRowNo("orderItemPage"); i++)
//		{
//			we = eu.readDataFromExcel("orderItemPage", i, 0);
//			quantity = eu.readDataFromExcel("orderItemPage", i, 1);
//		}
//		return we+" "+quantity;
		/*
		itemNo1.sendKeys("10");
		itemNo5.sendKeys("10");
		itemNo10.sendKeys("10");
		itemNo15.sendKeys("10");
		itemNo20.sendKeys("10");*/
		//postOrderBtn.click();
		
	}
	
	
	
	
}
