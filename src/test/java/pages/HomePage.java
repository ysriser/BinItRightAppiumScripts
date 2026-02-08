package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.ScrollUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;

import java.time.Duration;
import java.util.Collections;

public class HomePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By pointsCounter = By.id("iss.nus.edu.sg.webviews.bin:id/tvPointsCount");
    private By findBinsCard  = By.id("iss.nus.edu.sg.webviews.bin:id/cardFindBins");
    By findBinsCardXpath = By.xpath(
            "//android.widget.TextView[@text='Find Recycling Bins']" +
                    "/ancestor::androidx.cardview.widget.CardView");
    private By homeTab =
            AppiumBy.accessibilityId("Home");
    private By newsTab = By.id("iss.nus.edu.sg.webviews.bin:id/nav_news");
    private By recycleNowButton = By.id("btnRecycleNow");
    private By homeTitle = By.xpath("//android.widget.TextView[@text='Bin It Right']");
    By achievementsCard = By.xpath(
            "//androidx.cardview.widget.CardView[@resource-id='iss.nus.edu.sg.webviews.bin:id/cardAchievements']"
    );


    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }


    public void waitForHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pointsCounter));
    }

    public boolean isHomePageDisplayed() {
        try {
            driver.context("NATIVE_APP");

            wait.until(ExpectedConditions.presenceOfElementLocated(homeTitle));

            return true;
        } catch (Exception e) {
            System.out.println("Home page not detected: " + e.getMessage());
            return false;
        }
    }


    public void openFindRecyclingBins() {

        driver.context("NATIVE_APP");

        try { Thread.sleep(3000); } catch (Exception ignored) {}

        for (int i = 0; i < 3; i++) {
            swipeUpHard();
        }

        try { Thread.sleep(1500); } catch (Exception ignored) {}
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int y = (int) (size.height * 0.78);

        driver.executeScript("mobile: clickGesture", java.util.Map.of(
                "x", x,
                "y", y
        ));
    }

    private void swipeUpHard() {
        driver.executeScript("mobile: swipeGesture", java.util.Map.of(
                "left", 0,
                "top", 800,
                "width", 1080,
                "height", 1200,
                "direction", "up",
                "percent", 1.0
        ));
    }


    public void swipeUp(AndroidDriver driver) {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY   = (int) (size.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY
        ));
        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()
        ));
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                startX,
                endY
        ));
        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()
        ));

        driver.perform(Collections.singletonList(swipe));
    }

    public AchievementsPage goToAchievements() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(AppiumBy.accessibilityId("Home")).click();

        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.TextView[@text='Achievements']")
                )
        );


        org.openqa.selenium.Rectangle r = text.getRect();
        int x = r.getX() + r.getWidth() / 2;
        int y = r.getY() - 20;   // tap parent card area

        driver.executeScript("mobile: clickGesture", Map.of(
                "x", x,
                "y", y
        ));

        return new AchievementsPage(driver);
    }


    public NewsPage goToNews() {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        driver.findElement(AppiumBy.accessibilityId("News")).click();
        return new NewsPage(driver);
    }

    public EventsPage goToEvents() {
        try { driver.hideKeyboard(); } catch (Exception ignored) {}

        driver.findElement(AppiumBy.accessibilityId("Events")).click();
        return new EventsPage(driver);
    }

    public ProfilePage goToProfile() {
        try { driver.hideKeyboard(); } catch (Exception ignored) {}

        driver.findElement(AppiumBy.accessibilityId("Profile")).click();
        return new ProfilePage(driver);
    }


    public void clickRecycleNow() {
        ScrollUtil.scrollDown(driver);
        driver.findElement(recycleNowButton).click();
    }
}
