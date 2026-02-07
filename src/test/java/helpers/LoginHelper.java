package helpers;

import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;
import pages.HomePage;
import utils.ConfigReader;
import org.testng.Assert;

public class LoginHelper {

    public static HomePage loginWithValidUser(AndroidDriver driver) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("valid.username"),
                ConfigReader.get("valid.password")
        );

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Login failed: Home page not visible"
        );

        return homePage;
    }
}
