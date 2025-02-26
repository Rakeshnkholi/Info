package com.sun.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.base.*;
import com.sun.pages.*;
import com.sunmob.testdata.Testingdata;
public class AddcartTest extends TestBase
{
	@Test(dataProvider="checkoutData", dataProviderClass=Testingdata.class)
	public void clickonAddcart(String fname,String lname,String code)
	{
		//click on addcart and validate the cart url
		 loginapplication("standard_user","secret_sauce");
		 AddcartPage cart=new AddcartPage(driver);
		 cart.clickonaddCart();
		 
		 String cartExpectedurl="https://www.saucedemo.com/cart.html";
		 
		 Assert.assertEquals(cartExpectedurl, cart.validateaddcarturl());
		 
		 System.out.println(cart.validateaddcarturl());
		 cart.continueshop();
		 cart.additem();
		 cart.clickonaddCart();
		 cart.checkout();
		 
		 cart.checkoutdetails(fname,lname, code);
		 cart.orderconfirm();
		 cart.confirmationmessage();
		 driver.navigate().to("https://www.saucedemo.com/");
		 
		
		
	}

}
