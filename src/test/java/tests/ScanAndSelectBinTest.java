package tests;

import base.ProjectSpecificationMethods;
import helpers.LoginHelper;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ScanAndSelectBinTest extends ProjectSpecificationMethods {

    @Test
    public void scanAndSelectRecyclingBinFlow() {

        // Login
        HomePage home = LoginHelper.loginWithValidUser(driver);

        // Recycle Now
        home.clickRecycleNow();

        // Scan Home
        ScanHomePage scanHome = new ScanHomePage(driver);
        Assert.assertTrue(scanHome.isDisplayed());
        scanHome.clickStartScanning();

        // Scan Item
        ScanItemPage scanItem = new ScanItemPage(driver);
        Assert.assertTrue(scanItem.isDisplayed());
        scanItem.takePhoto();
        scanItem.waitForScanResult();

        // Scan Result
        ScanResultPage result = new ScanResultPage(driver);
        Assert.assertTrue(result.isResultDisplayed());
        result.confirmRecycle();

        // Select Bin
        NearbyBinPage selectBin = new NearbyBinPage(driver);
        Assert.assertTrue(selectBin.isDisplayed());
        selectBin.selectFirstBin();

        CheckInPage checkIn = new CheckInPage(driver);
        Assert.assertTrue(checkIn.isDisplayed(), "Check-in page not visible");

        // + + + -
        checkIn.increaseItems(3);
        checkIn.decreaseItems(1);

        Assert.assertEquals(checkIn.getItemCount(), 2,
                "Item count calculation incorrect");

        // Record video
        checkIn.clickRecordVideo();

        VideoRecorderPage recorder = new VideoRecorderPage(driver);
        Assert.assertTrue(recorder.isDisplayed(), "Video recorder not opened");

        recorder.recordVideoForSeconds(7);

        // Submit
        checkIn.waitForCheckInPage();
        checkIn.scrollToSubmit();
        checkIn.clickSubmit();

        String status = checkIn.getStatusMessage();
        Assert.assertTrue(
                status.contains("successful") || status.contains("failed"),
                "Unexpected submit result message: " + status
        );
    }
}
