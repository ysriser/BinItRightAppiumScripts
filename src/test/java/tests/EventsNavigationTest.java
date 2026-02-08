package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EventsPage;
import pages.HomePage;

public class EventsNavigationTest extends ProjectSpecificationMethods {

    @Test
    public void navigateToEventsAndValidate() {

        HomePage home = LoginHelper.loginWithValidUser(driver);

        EventsPage eventsPage = home.goToEvents();

        Assert.assertTrue(
                eventsPage.isEventsScreenDisplayed(),
                "Events screen should be visible after clicking Events tab");
    }
}
