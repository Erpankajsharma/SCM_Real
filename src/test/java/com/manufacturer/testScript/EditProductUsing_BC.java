package com.manufacturer.testScript;

import static org.testng.Assert.fail;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.GenericUtilities.BaseClass;
import com.scm.pom.ManufacturerHomePage;
import com.scm.pom.Manufacturer_AddProductPage;
import com.scm.pom.Manufacturer_EditProductPage;
import com.scm.pom.ViewProductPage;

@Listeners(com.scm.GenericUtilities.ListnerImplimentationClass.class)
public class EditProductUsing_BC extends BaseClass{
	
	
	@Test(groups = {"smoke"})
	public void editProduct() throws InterruptedException
	{
		ManufacturerHomePage mhp=new ManufacturerHomePage(d);
		mhp.addProducts();
		
		Manufacturer_AddProductPage mapp=new Manufacturer_AddProductPage(d);
		mapp.addproductsViaManuf();
		
		wdu.acceptAlert(d);
		
		mhp.productListFeature();
		
		fail();
		
		ViewProductPage vpp=new ViewProductPage(d);
		vpp.editbutton();
		
		Manufacturer_EditProductPage mepp=new Manufacturer_EditProductPage(d);
		mepp.editProduct();
		mapp.getEnable().click();
		mepp.updateproduct();
		
		wdu.acceptAlert(d);
		System.out.println("edit product");
	}
	
	
	@Test(groups = {"smoke"})
	public void simple1()
	{
		Reporter.log("simple 1", true);
	}
	
	@Test(groups = {"regression"})
	public void simple2()
	{
		Reporter.log("simple 2", true);
	}

}
