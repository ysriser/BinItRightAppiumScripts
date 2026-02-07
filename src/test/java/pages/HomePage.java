package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {

    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By pointsCounter = By.id("tvPointsCount");
    private By findBinsCard = By.id("cardFindBins");

    public boolean isHomePageDisplayed() {
        return driver.findElement(pointsCounter).isDisplayed();
    }

    public void openFindRecyclingBins() {
        driver.findElement(findBinsCard).click();
    }
}
