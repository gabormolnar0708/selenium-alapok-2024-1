import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOfFluentWait {

    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        //chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://formy-project.herokuapp.com/");
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(10000))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Teszt Gábor");

        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();

        driver.quit();
    }
}
