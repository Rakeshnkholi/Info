package com.sun.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils 
{
	protected static WebDriver driver;
	
	public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() 
    {
        return driver;
    }
	
	//Enter text
	public static void entertext( WebElement element, String text )
	{
		element.sendKeys(text);
	}
	
	//Click 
	public static void enterclick(WebElement element)
	{
		element.click();
	}
	
	//getText
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	
	//clearText field
	public static void clearText(WebElement element)
	{
		element.clear();
	}
	
	// Press Enter key
    public static void pressEnterKey(WebElement element) 
    {
        element.sendKeys(Keys.ENTER);
    }
	
	
	//Wait for element to visiable
	public static void waitforElementvisiable(WebElement element, int timeout )
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Wait for element to clickable
	public static void waitforElementclickable(WebElement element, int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//GetPage title 
	public static String getPageTitle()
	{
		return driver.getTitle();
	}
	
	//Get Current url
	public static String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	//dropdown class actions
	public static void selectDropDownbyvalue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
				
	}
	public static void selectDropDownbyVisabletext(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void selectDropDownbyIndexValue(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void deselectdropdownByvalue(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.deselectByValue(text);
	}
	
	//Alerts actions
	public static void acceptAlert(WebElement element)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static void dismissAlert(WebElement element)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public static String getAlertText(WebElement element)
	{
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	
	//Frames
	//Swich to frame by id/name
	public static void SwitchToFrameBynameORiD(String nameORid)
	{
		driver.switchTo().frame(nameORid);
	}
	
	//Switch to frame by WebElement
	public static void SwitchToFrameByWebElement(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	//Switch to default Content
	public static void SwitchToFrameDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
	//Take Screenshot
	public static void TakeScreenshot(String filepaht)
	{
		
	}
	
	//Scoll to element
	public static void ScrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//Actions class
	public static void MousehoverActions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	// Drag and drop element
    public static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Double-click element
    public static void doubleClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Right-click (context click) element
    public static void rightClickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
	
	// Switch to a new window or tab
    public static void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Switch to the original window
    public static void switchToOriginalWindow(String originalWindowHandle) {
        driver.switchTo().window(originalWindowHandle);
    }

    // Close current window and switch back to the original window
    public static void closeCurrentWindowAndSwitchToOriginal(String originalWindowHandle) {
        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }
	
}

	
	


   