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
    public void verifyFindRecyclingBinFlow() {

        // Login
        HomePage homePage = LoginHelper.loginWithValidUser(driver);

        // Navigate to Find Recycling Bins
        homePage.openFindRecyclingBins();
        FindRecyclingBinPage bins = new FindRecyclingBinPage(driver);

        Assert.assertTrue(bins.isMapVisible(),
                "Map should be visible");
        Assert.assertTrue(bins.isListVisible(),
                "Bin list should be visible");

        // Filters
        bins.filterBlueBins();
        bins.filterEWaste();

        // Directions
        bins.clickFirstDirection();
    }
}
