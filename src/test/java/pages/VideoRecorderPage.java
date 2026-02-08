package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class VideoRecorderPage {

    private AndroidDriver driver;

    public VideoRecorderPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By startBtn = By.id("btnStartRecording");
    private By closeBtn = By.id("btnClose");

    public boolean isDisplayed() {
        return driver.findElement(startBtn).isDisplayed();
    }

    public void recordVideoForSeconds(int seconds) {

        driver.findElement(startBtn).click();

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {}

        driver.findElement(closeBtn).click();
    }
}
