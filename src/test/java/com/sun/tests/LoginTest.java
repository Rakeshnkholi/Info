package com.sun.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.base.*;
import com.sun.pages.*;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import com.sun.utils.*;


public class LoginTest extends TestBase 
{
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login functionality with valid credentials")
    @Step("Executing test case for login")
    public void validateurl()
    {
    	 loginfo("Starting Login Test");
    	 
    	 loginapplication("standard_user","secret_sauce");
    	 loginfo("Login is completed");
    	 
    	 String Expectedurl="https://www.saucedemo.com/inventory.html";
    	 Assert.assertEquals(Expectedurl, login.validdateTitle());
    	 loginfo("Validating the homepage url");
    	 
    	 login.scrolldown();
    	 
    	// Capture Screenshot for Allure
         AllureUtils.captureScreenshot(driver);

         // Attach Log Details
         AllureUtils.attachLog("Login test executed successfully.");
    	 
    }
	
	

}
