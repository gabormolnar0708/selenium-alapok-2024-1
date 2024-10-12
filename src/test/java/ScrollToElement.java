import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollToElement {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-search-engine-choice-screen");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        driver.get("https://formy-project.herokuapp.com/");
        WebElement scrollLink = driver.findElement(By.partialLinkText("Page Scroll"));
        scrollLink.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        WebElement fullNameField = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(fullNameField).build().perform();

        //fullNameField.sendKeys("Test Name");

        //driver.quit();
    }
}
