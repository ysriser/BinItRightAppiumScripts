package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class NewsPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By newsTitle =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Recycling News\")"
            );
    public NewsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isNewsScreenDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newsTitle))
                .isDisplayed();
    }
}
