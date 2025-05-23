package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass1;

public class TC002_LoginTest extends BaseClass1 {

    @Test
    public void verify_login() {
        logger.info("*** Starting Login Test ***");

        try {
            // Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));   // Make sure 'p' is initialized in BaseClass1
            lp.setPassword(p.getProperty("pass"));
            lp.clicklogin();

            // My Account Page
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();

            Assert.assertTrue(targetPage, "Login failed: My Account page not displayed");
            logger.info("*** Login Test Passed ***");

        } catch (Exception e) {
            logger.error("❌ Login Test Failed due to exception: " + e.getMessage(), e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("*** Finished Login Test ***");
    }
}
