package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ScanResultPage {

    private AndroidDriver driver;

    public ScanResultPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By recycleButton = By.id("btnRecycle");
    private By categoryText = By.id("tvCategory");

    public boolean isResultDisplayed() {
        return driver.findElement(categoryText).isDisplayed();
    }

    public void confirmRecycle() {
        driver.findElement(recycleButton).click();
    }
}

