package com.manufacturer.testScript;

import org.testng.annotations.Test;

import com.scm.GenericUtilities.BaseClass;
import com.scm.pom.ManufacturerHomePage;
import com.scm.pom.Manufacturer_AddProductPage;

public class AddProductUsing_BC extends BaseClass {
	
	@Test(groups = {"smoke"})
	public void addProduct() throws InterruptedException
	{
		ManufacturerHomePage mhp=new ManufacturerHomePage(d);
		mhp.addProducts();
		
		Manufacturer_AddProductPage mapp=new Manufacturer_AddProductPage(d);
		mapp.addproductsViaManuf();
		
		wdu.acceptAlert(d);
		
		mhp.productListFeature();
		
		System.out.println("add product");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void simple1()
	{
		System.out.println("simple 1");
	}
	
	@Test(groups = {"regression"})
	public void simple2()
	{
		System.out.println("simple 2");
	}

}
