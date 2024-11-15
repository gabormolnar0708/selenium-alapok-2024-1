package com.petstore.pages;

import com.petstore.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By welcomeMessage = By.id("WelcomeContent");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessageContent() {
        return getText(welcomeMessage);
    }
}
