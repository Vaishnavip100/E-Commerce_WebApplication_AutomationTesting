package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void handleAdsIfPresent() {
        try {
            if (driver.getCurrentUrl().contains("google_vignette")) {
                driver.navigate().back();
            }
        } catch (Exception e) {
            // ignore safely
        }
    }

    public void click(By locator) {
        handleAdsIfPresent();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void type(By locator, String text) {
        handleAdsIfPresent();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public WebElement waitForElement(By locator) {
        handleAdsIfPresent();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        handleAdsIfPresent();
        return driver.findElements(locator).size() > 0;
    }
}