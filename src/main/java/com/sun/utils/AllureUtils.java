package com.sun.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class AllureUtils {

    /**
     * Capture screenshot and attach it to Allure report.
     *
     * @param driver WebDriver instance
     * @return Screenshot as byte array
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Attach text logs to Allure report.
     *
     * @param message Log message to attach
     */
    @Attachment(value = "Log Details", type = "text/plain")
    public static String attachLog(String message) {
        return message;
    }

    /**
     * Attach an HTML report or API response to Allure.
     *
     * @param htmlContent HTML content to attach
     */
    @Attachment(value = "HTML Content", type = "text/html")
    public static String attachHtml(String htmlContent) {
        return htmlContent;
    }

    /**
     * Attach API response in JSON format.
     *
     * @param json JSON content to attach
     */
    @Attachment(value = "API Response", type = "application/json")
    public static String attachJson(String json) {
        return json;
    }
}
