package tests;

import org.testng.annotations.Test;

public class AppLaunchTest extends ProjectSpecificationMethods {

	@Test
    public void appShouldLaunch() {
        // If app launches without crash → test passes
        System.out.println("App launched successfully");

		Assert.assertNotNull(driver, "Driver should be initialized");
    }
}
