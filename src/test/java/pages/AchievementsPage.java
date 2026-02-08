package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AchievementsPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By achievementsList =
            By.id("iss.nus.edu.sg.webviews.bin:id/rvAchievements");

    public AchievementsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isAchievementsScreenDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Achievements']")
        )).isDisplayed();

    }
}
