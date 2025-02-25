package com.sun.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.base.*;
import com.sun.pages.*;
public class AddcartTest extends TestBase
{
	@Test
	public void clickonAddcart()
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
		 
		 cart.checkoutdetails("Rakesh","Nayak","560067");
		 cart.orderconfirm();
		 cart.confirmationmessage();
		 
		
		
	}

}
