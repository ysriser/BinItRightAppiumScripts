package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;

public class NewsNavigationTest extends ProjectSpecificationMethods {

    @Test
    public void navigateToNewsAndValidate() {

        HomePage home = LoginHelper.loginWithValidUser(driver);
        NewsPage newsPage = home.goToNews();

        Assert.assertTrue(
                newsPage.isNewsScreenDisplayed(),
                "News screen should be visible after clicking News tab"
        );
    }
}
