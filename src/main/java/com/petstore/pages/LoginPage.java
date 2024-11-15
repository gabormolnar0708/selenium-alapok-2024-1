package com.petstore.pages;

import com.petstore.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameLoc = By.name("username");
    private final By passwordLoc = By.name("password");
    private final By submitLoc = By.name("signon");

    String url = "https://petstore.octoperf.com/actions/Account.action?signonForm=";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username) {
        inputText(usernameLoc, username);
    }

    public void fillPassword(String password) {
        inputText(passwordLoc, password);
    }

    public void submitLogin() {
        click(submitLoc);
    }

    public void navigateToLoginPage() {
        open(url);
    }

    public void verifyPageLoaded() {
        waitUntilElementIsVisible(usernameLoc);
    }
}
