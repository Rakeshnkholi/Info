package com.sun.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.base.*;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sun.utils.*;

public class LoginPage {
       WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")private WebElement username;

    @FindBy(xpath = "//input[@id='password']")private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")private WebElement submit;

    @FindBy(xpath="//div[.='Test.allTheThings() T-Shirt (Red)']") private WebElement FindItem;
    
    @FindBy(css="#react-burger-menu-btn") private WebElement openmenu;
    
    
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginapplication(String Loginname, String pwd) 
    {
        if (username == null) {
            throw new NullPointerException("username WebElement is not initialized");
        }
        /*username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submit.click();*/	
        
        SeleniumUtils.entertext(username,Loginname);
        SeleniumUtils.entertext(password, pwd);
        SeleniumUtils.enterclick(submit);
        SeleniumUtils.enterclick(openmenu);
    }
    
    public String validdateTitle()
    {
    	
    	String actualurl=SeleniumUtils.getCurrentURL();
		return actualurl;
    }
    
    public void scrolldown()
    {
    	SeleniumUtils.ScrollToElement(FindItem);
    }
}
