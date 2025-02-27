package com.sun.tests;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.base.*;
import com.sun.pages.*;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import com.sun.utils.*;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase 
{
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException
	{
		//Reusable method to fetch login data
		return ExcelReader.getLoginTestData("Sheet1");
	}
	
	
	
    @Test(dataProvider="loginData")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login functionality with valid credentials")
    @Step("Executing test case for login")
    public void Testlogin(String username, String password)
    {
    	String expectedurl="https://www.saucedemo.com/inventory.html";
    	 
    	 loginfo("Starting Login Test");
    	 
    	 loginapplication(username,password);
    	 String currenturl =SeleniumUtils.getCurrentURL();
    	  
    	 SoftAssert softAssert=new SoftAssert();
    	 
    	 driver.navigate().back();

    	 try
    	 {
    	 
    	 softAssert.assertEquals(currenturl, expectedurl," Login Failed please enter correct details");
    	 }
    	 catch (AssertionError e)
    	 {
    		 logerror("Test Failed. Current URL: " + currenturl + ", Expected URL: " + expectedurl);
    		 logerror("Error Message: " + e.getMessage());
    	 }
    	 
    	 
    	 // Capture Screenshot for Allure
         AllureUtils.captureScreenshot(driver);

         // Attach Log Details
         AllureUtils.attachLog("Login test executed successfully.");
    	 
         softAssert.assertAll();
         
         loginfo("Login Test Success");
    }
	
	

}
