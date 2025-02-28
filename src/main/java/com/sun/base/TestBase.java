package com.sun.base;

import java.time.Duration;
import com.sun.utils.*;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.sun.pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;

	public class TestBase 
	{
		protected WebDriver driver;
		protected LoginPage login ;
		protected static final Logger log= LogManager.getLogger(TestBase.class);
		
		@BeforeClass
		@Step("Starting Browser and Navigating to Application")
		public void setup()
		{
			log.info("Setting up the environment");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	        //driver=new EdgeDriver();
			driver=new ChromeDriver();
			SeleniumUtils.setDriver(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			login = new LoginPage(driver);
			driver.get("https://www.saucedemo.com/");
			AllureUtils.attachLog("Browser Launched Successfully");

					
		}
		
		@AfterClass
		public void tearDown() {
		    if (driver != null) {
		        //driver.quit();
		    }
		}
		
		
		protected void loginfo(String message)
		{
			log.info(message);
		}
		
		protected void logerror(String message)
		{
			log.info(message);
		}
		
		protected void logDebug(String message)
		{
			log.info(message);
		}
		
		
		
		
		public void loginapplication(String Loginname, String pwd) 
	    {
	        if (login == null) {
	            throw new NullPointerException("username WebElement is not initialized");
	        }
	            login.loginapplication(Loginname,pwd);
	            
	        
	    }
	 
	    }
	

