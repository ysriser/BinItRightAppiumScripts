package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LogoutTest extends ProjectSpecificationMethods {

    @Test
    public void logoutFromProfileAndValidate() {

        HomePage home = LoginHelper.loginWithValidUser(driver);
        ProfilePage profile = home.goToProfile();
        LoginPage loginPage = profile.logout();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Login screen should be visible after logout");
    }
}
