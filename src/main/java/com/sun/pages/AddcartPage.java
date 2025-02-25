package com.sun.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.utils.SeleniumUtils;

public class AddcartPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement addcart;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueshop;
	
	@FindBy(xpath="(//button[.='Add to cart'])[1]") private WebElement additemcart;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkout;
	@FindBy(xpath="//input[@id='first-name']") private WebElement Firstname;
	@FindBy(xpath="//input[@id='last-name']") private WebElement Lastname;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipcode;
	@FindBy(xpath="//input[@id='continue']") private WebElement checkoutconfirm;
	@FindBy(xpath="//button[@id='finish']") private WebElement Finish;
	@FindBy(xpath="//div//h2[.='Thank you for your order!']")private WebElement message;
	
	public AddcartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickonaddCart()
	{
		SeleniumUtils.enterclick(addcart);
	}
	
	public String validateaddcarturl()
	{
		 String actualurl=SeleniumUtils.getCurrentURL();
		 
		 return actualurl;
	}
	public void continueshop()
	{
		SeleniumUtils.enterclick(continueshop);
		
	}
	public void additem()
	{
		SeleniumUtils.enterclick(additemcart);
	}
	public void checkout()
	{
		SeleniumUtils.enterclick(checkout);
	}
	
	public void checkoutdetails(String firstname, String lastname, String code)
	{
		SeleniumUtils.entertext(Firstname, firstname);
		SeleniumUtils.entertext(Lastname, lastname);
		SeleniumUtils.entertext(zipcode, code);
		SeleniumUtils.enterclick(checkoutconfirm);
		
		
	}
	public void orderconfirm()
	{
		SeleniumUtils.enterclick(Finish);
	}
	public void confirmationmessage()
	{
		System.out.println(SeleniumUtils.getText(message));
	}
		
	

}
