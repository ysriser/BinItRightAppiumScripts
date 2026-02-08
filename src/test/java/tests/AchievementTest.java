package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AchievementsPage;
import pages.HomePage;

public class AchievementTest extends ProjectSpecificationMethods {

    @Test
    public void navigateToAchievementsAndValidate() {

        HomePage home = LoginHelper.loginWithValidUser(driver);
        AchievementsPage achievementsPage = home.goToAchievements();

        Assert.assertTrue(
                achievementsPage.isAchievementsScreenDisplayed(),
                "Achievements screen should be displayed");
    }
}
