package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ScanHomePage {

    private AndroidDriver driver;
    private By startScanButton = By.id("btnStartScan");

    public ScanHomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElement(startScanButton).isDisplayed();
    }

    public void clickStartScanning() {
        driver.findElement(startScanButton).click();
    }
}
