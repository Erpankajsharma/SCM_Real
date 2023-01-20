package com.retailer.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scm.GenericUtilities.BaseClass;
import com.scm.pom.MyOrdersPage;
import com.scm.pom.OrderDetailsPage;
import com.scm.pom.OrderItemsPage;
import com.scm.pom.RetailerHomePage;

public class NewOrderModuleVerifyNOTest_BC extends BaseClass{
	
	@Test(groups = {"smoke"})
	public void verifyNewOrderTest_BC() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		PostAnOrderUsing_BC paoubc=new PostAnOrderUsing_BC();
		paoubc.PostAnOrder();
		
		RetailerHomePage rhp=new RetailerHomePage(d);
		rhp.clickNewOrderFeature(d);
		
		OrderItemsPage oip=new OrderItemsPage(d);
		oip.orderIte(eu);
		
		Thread.sleep(2000);
		
		MyOrdersPage mop=new MyOrdersPage(d);
		mop.clickOnLastDetailsLink();
		
		OrderDetailsPage odp=new OrderDetailsPage(d);
		
		//Assert.assertEquals(odp.NewOrderNo(), mop.expOrderIdGot());
		
		
		if(mop.expOrderIdGot().equals(odp.NewOrderNo()))
		{
			System.out.println("Newly created order is successfully displayed in My orders page.");
		}
	}
}
