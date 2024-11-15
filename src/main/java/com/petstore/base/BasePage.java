package com.petstore.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    Duration defaultDuration = Duration.ofSeconds(5);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void inputText(By locator, String text) {
        waitUntilElementIsVisible(locator);
        WebElement webElement = driver.findElement(locator);
        webElement.sendKeys(text);
    }

    public void click(By locator) {
        waitUntilElementIsClickable(locator);
        WebElement webElement = driver.findElement(locator);
        webElement.click();
    }

    public void waitUntilElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, defaultDuration);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilElementIsVisible(By locator, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, defaultDuration);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
