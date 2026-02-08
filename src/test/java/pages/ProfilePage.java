package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScrollUtil;

import java.time.Duration;


public class ProfilePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By logoutButton =
            By.id("iss.nus.edu.sg.webviews.bin:id/logoutBtn");

    private By profileName =
            By.id("iss.nus.edu.sg.webviews.bin:id/profileName");

    private By profileHeader = AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"My Profile\")");

    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isProfileScreenDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(profileHeader)
        ).isDisplayed();
    }


    public void scrollToLogout() {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().resourceId(" +
                                "\"iss.nus.edu.sg.webviews.bin:id/logoutBtn\"))"
                )
        );
    }

    public LoginPage logout() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader));

        By logoutLocator = By.id("iss.nus.edu.sg.webviews.bin:id/logoutBtn");

        for (int i = 0; i < 3; i++) {
            ScrollUtil.scrollDown(driver);

            try {
                Thread.sleep(400);
            } catch (InterruptedException ignored) {}

            if (!driver.findElements(logoutLocator).isEmpty()) {
                break;
            }
        }

        org.openqa.selenium.WebElement logoutBtn = driver.findElement(logoutLocator);
        driver.executeScript("mobile: clickGesture", java.util.Map.of(
                "elementId",
                ((org.openqa.selenium.remote.RemoteWebElement) logoutBtn).getId()
        ));

        return new LoginPage(driver);
    }


}
