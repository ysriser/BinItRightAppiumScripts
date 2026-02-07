package pages;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;


public class HomePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By cardFindBins = By.id("cardFindBins");
    private By pointsCounter = By.id("tvPointsCount");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void waitForHomePage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(pointsCounter));
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(pointsCounter).isDisplayed();
    }

    public void openFindRecyclingBins() {

        waitForHomePage();

        By findBinsCard = By.id("cardFindBins");

        int maxSwipes = 2;
        boolean found = false;

        for (int i = 0; i < maxSwipes; i++) {

            if (driver.findElements(findBinsCard).size() > 0) {
                found = true;
                break;
            }

            swipeUp();
        }

        if (!found) {
            throw new RuntimeException("Find Recycling Bins card not found after scrolling");
        }

        WebElement card = wait.until(
                ExpectedConditions.elementToBeClickable(findBinsCard)
        );
        card.click();

    }


    private void swipeUp() {

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        int startX = width / 2;
        int startY = (int) (height * 0.75);
        int endY   = (int) (height * 0.25);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY
                )
        );

        swipe.addAction(
                finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
        );

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(600),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY
                )
        );

        swipe.addAction(
                finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())
        );

        driver.perform(Collections.singletonList(swipe));
    }


}
