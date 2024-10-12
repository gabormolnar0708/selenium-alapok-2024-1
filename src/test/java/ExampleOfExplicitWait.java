import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOfExplicitWait {

    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        //chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        driver.get("https://formy-project.herokuapp.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Key and Mouse Press")));
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Teszt Gábor");

        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();

        driver.quit();
    }
}
