package com.petstore.logintest;

import com.petstore.base.BaseTest;
import com.petstore.pages.LoginPage;
import com.petstore.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.AssertTrue.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void userCanNavigateToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.verifyPageLoaded();
    }

    @Test
    void userCanLoginWithValidCredentails() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.fillUsername("gabor.molnar20241014");
        loginPage.fillPassword("asdf1234");
        loginPage.submitLogin();
        MainPage mainPage = new MainPage(driver);

        assertTrue(mainPage.getWelcomeMessageContent(), "Welcome test!\n");
    }
}
