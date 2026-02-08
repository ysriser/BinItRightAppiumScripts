package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ScanItemPage {

    private AndroidDriver driver;
    private By takePhotoButton = By.id("btnTakePhoto");
    private By loadingOverlay = By.id("loadingOverlay");

    public ScanItemPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElement(takePhotoButton).isDisplayed();
    }

    public void takePhoto() {
        driver.findElement(takePhotoButton).click();
    }

    public void waitForScanResult() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ignored) {}
    }
}
