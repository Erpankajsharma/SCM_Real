package com.retailer.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.scm.GenericUtilities.BaseClass;
import com.scm.pom.OrderItemsPage;
import com.scm.pom.RetailerHomePage;

public class PostAnOrderUsing_BC extends BaseClass {
	
	@Test
	public void PostAnOrder() throws EncryptedDocumentException, IOException
	{
		
		
		RetailerHomePage rhp=new RetailerHomePage(d);
		rhp.clickNewOrderFeature(d);
		
		OrderItemsPage oip=new OrderItemsPage(d);
		oip.orderIte(eu);
		
	}

}
