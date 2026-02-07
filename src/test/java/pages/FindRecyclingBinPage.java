package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FindRecyclingBinPage {

    private AndroidDriver driver;

    public FindRecyclingBinPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By mapContainer = By.id("mapContainer");
    private By recyclerView = By.id("binsRecyclerView");

    private By chipAll = By.id("chipAll");
    private By chipBlueBin = By.id("chipBlueBin");
    private By chipEwaste = By.id("chipEwaste");

    private By firstDirectionButton =
            By.id("btnDirections");

    public boolean isMapVisible() {
        return driver.findElement(mapContainer).isDisplayed();
    }

    public boolean isListVisible() {
        return driver.findElement(recyclerView).isDisplayed();
    }

    public void filterBlueBins() {
        driver.findElement(chipBlueBin).click();
    }

    public void filterEWaste() {
        driver.findElement(chipEwaste).click();
    }

    public void clickFirstDirection() {
        driver.findElement(firstDirectionButton).click();
    }
}
