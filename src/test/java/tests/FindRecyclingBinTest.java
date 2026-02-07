package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import pages.LoginPage;
import pages.HomePage;
import pages.FindRecyclingBinPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindRecyclingBinTest extends ProjectSpecificationMethods {

    @Test
    public void verifyMapAndListAreDisplayed() {

        // Login
        HomePage homePage = LoginHelper.loginWithValidUser(driver);
        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page was not displayed after login"
        );

        homePage.openFindRecyclingBins();

        FindRecyclingBinPage bins = new FindRecyclingBinPage(driver);
        bins.waitForPageToLoad();

        Assert.assertTrue(
                bins.isMapVisible(),
                "Map view is not visible on Find Recycling Bins page"
        );

        Assert.assertTrue(
                bins.isListVisible(),
                "Bins list is not visible on Find Recycling Bins page"
        );
    }

    @Test
    public void verifyBlueBinFiltering() {

        HomePage homePage = LoginHelper.loginWithValidUser(driver);
        homePage.openFindRecyclingBins();

        FindRecyclingBinPage bins = new FindRecyclingBinPage(driver);
        bins.waitForPageToLoad();

        bins.filterBlueBins();

        Assert.assertTrue(
                bins.areAllBinsOfType("General"),
                "Filtered results contain non-BlueBin items"
        );
    }

    @Test
    public void verifyEWasteFiltering() {

        HomePage homePage = LoginHelper.loginWithValidUser(driver);
        homePage.openFindRecyclingBins();

        FindRecyclingBinPage bins = new FindRecyclingBinPage(driver);
        bins.waitForPageToLoad();

        bins.filterEWaste();

        Assert.assertTrue(
                bins.areAllBinsOfType("E-Waste"),
                "Filtered results contain non E-Waste items"
        );
    }

    @Test
    public void verifyDirectionButtonFlow() {

        HomePage homePage = LoginHelper.loginWithValidUser(driver);
        homePage.openFindRecyclingBins();

        FindRecyclingBinPage bins = new FindRecyclingBinPage(driver);
        bins.waitForPageToLoad();

        bins.clickFirstDirection();

        Assert.assertTrue(
                bins.isGoogleMapsOpened(),
                "Clicking Directions did not open Google Maps"
        );

    }
}
