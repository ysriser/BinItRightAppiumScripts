package tests;

import base.ProjectSpecificationMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends ProjectSpecificationMethods {

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage login = new LoginPage(driver);
        login.login("wronguser", "wrongpass");

        Assert.assertTrue(login.isLoginPageDisplayed(),
                "Login page should remain on invalid credentials");
    }
}
