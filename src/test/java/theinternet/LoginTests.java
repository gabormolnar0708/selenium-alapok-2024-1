package theinternet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;
    //ChromeOptions chromeOptions;
    String baseUrl = "https://the-internet.herokuapp.com/";

    By formAuthenticationLinkLoc = By.partialLinkText("Form Authentication");
    By userNameLoc = By.id("username");
    By passwordLoc = By.id("password");

    @BeforeEach
    void beginWebTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    void endWebTest() {
        this.driver.quit();
    }

    @Test
    void userCanLoginWithValidCredentials() {
        driver.get(baseUrl);
        WebElement authenticationLink = driver.findElement(formAuthenticationLinkLoc);
        authenticationLink.click();
        inputText(userNameLoc, "tomsmith");
        inputText(passwordLoc, "asdf1234");

    }

    void inputText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement webElement = driver.findElement(locator);
        webElement.sendKeys(text);
    }
}
