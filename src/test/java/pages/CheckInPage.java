package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class CheckInPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By increaseBtn = By.id("btnIncrease");
    private By decreaseBtn = By.id("btnDecrease");
    private By itemCount = By.id("tvItemCount");

    private By recordVideoBtn = By.id("btnRecordVideo");
    By submitBtn =
            AppiumBy.accessibilityId("submit_checkin");
    private By statusMessage = By.id("tvStatusMessage");

    public CheckInPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }


    public boolean isDisplayed() {
        return driver.findElement(itemCount).isDisplayed();
    }

    public void increaseItems(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(increaseBtn).click();
        }
    }

    public void decreaseItems(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(decreaseBtn).click();
        }
    }

    public int getItemCount() {
        return Integer.parseInt(driver.findElement(itemCount).getText());
    }

    public void clickRecordVideo() {
        driver.findElement(recordVideoBtn).click();
    }


    public void scrollToSubmit() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), 500, 1500));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), 500, 500));
        swipe.addAction(finger.createPointerUp(0));

        driver.perform(Collections.singletonList(swipe));
    }

    public void waitForCheckInPage() {
        driver.context("NATIVE_APP");

        wait.until(ExpectedConditions.presenceOfElementLocated(statusMessage));
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public String getStatusMessage() {
        WebElement msg = driver.findElement(statusMessage);
        return msg.isDisplayed() ? msg.getText() : "";
    }
}
