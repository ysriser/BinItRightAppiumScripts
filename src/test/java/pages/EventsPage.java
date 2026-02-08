package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EventsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    By eventsTitle =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Events\")"
            );
    public EventsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isEventsScreenDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(eventsTitle)
        ).isDisplayed();
    }
}
