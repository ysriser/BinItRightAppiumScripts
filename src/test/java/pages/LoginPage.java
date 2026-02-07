package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By usernameInput =
            By.xpath("//android.widget.EditText[@hint='Enter your username']");
    private By passwordInput =
            By.xpath("//android.widget.EditText[@hint='Enter your password']");
    private By signInButton = By.id("btnSignIn");

    public void login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }
}

