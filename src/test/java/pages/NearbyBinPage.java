package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NearbyBinPage {

    private AndroidDriver driver;

    public NearbyBinPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By recyclerView = By.id("binsRecyclerView");
    private By binCards = By.id("cardRoot");
    private By selectButton = By.id("selectButton");

    public boolean isDisplayed() {
        return driver.findElement(recyclerView).isDisplayed();
    }

    public void selectFirstBin() {
        List<WebElement> bins = driver.findElements(binCards);
        bins.get(0).click();

        driver.findElement(selectButton).click();
    }
}
