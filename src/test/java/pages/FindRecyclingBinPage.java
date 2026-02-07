package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FindRecyclingBinPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By mapContainer = By.id("mapContainer");
    private By recyclerView = By.id("binsRecyclerView");

    private By chipAll = By.id("chipAll");
    private By chipBlueBin = By.id("chipBlueBin");
    private By chipEwaste = By.id("chipEwaste");
    private By binTypeText = By.id("txtType");

    private By firstDirectionButton = By.id("btnDirections");


    public FindRecyclingBinPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mapContainer));
        wait.until(ExpectedConditions.visibilityOfElementLocated(recyclerView));
    }

    public boolean isMapVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(mapContainer)
        ).isDisplayed();
    }

    public boolean isListVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(recyclerView)
        ).isDisplayed();

    }

    public void filterBlueBins() {
        wait.until(ExpectedConditions.elementToBeClickable(chipBlueBin)).click();
        waitForListRefresh();
    }

    public void filterEWaste() {
        wait.until(ExpectedConditions.elementToBeClickable(chipEwaste)).click();
        waitForListRefresh();
    }

    private void waitForListRefresh() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(binTypeText, 0));
    }

    public boolean areMultipleBinTypesDisplayed() {

        List<WebElement> types = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(binTypeText));

        if (types.size() < 2) return false;

        String firstType = types.get(0).getText().trim();

        for (WebElement type : types) {
            if (!type.getText().trim().equalsIgnoreCase(firstType)) {
                return true; // mixed types = all bins
            }
        }
        return false;
    }


    public boolean areAllBinsOfType(String expectedType) {

        List<WebElement> types = driver.findElements(binTypeText);

        if (types.isEmpty()) {
            return false; // no data = test should fail
        }

        for (WebElement type : types) {
            if (!type.getText().trim().equalsIgnoreCase(expectedType)) {
                return false;
            }
        }
        return true;
    }

    public void clickFirstDirection() {
        List<WebElement> buttons =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(firstDirectionButton));

        buttons.get(0).click();
    }

    public boolean isGoogleMapsOpened() {

        WebDriverWait pkgWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        boolean opened = pkgWait.until(d -> {
            String pkg = driver.getCurrentPackage();
            System.out.println("Current package: " + pkg);
            return pkg.contains("google.android.apps.maps");
        });


        driver.navigate().back();

        return opened;
    }

}
