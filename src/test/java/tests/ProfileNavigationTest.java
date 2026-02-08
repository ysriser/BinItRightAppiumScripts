package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;

public class ProfileNavigationTest extends ProjectSpecificationMethods {

    @Test
    public void navigateToProfileAndValidate() {

        HomePage home = LoginHelper.loginWithValidUser(driver);
        ProfilePage profilePage = home.goToProfile();

        Assert.assertTrue(
                profilePage.isProfileScreenDisplayed(),
                "Profile screen should be visible after clicking Profile tab"
        );
    }
}
