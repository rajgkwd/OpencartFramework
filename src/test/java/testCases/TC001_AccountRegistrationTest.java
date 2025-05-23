package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass1;

public class TC001_AccountRegistrationTest extends BaseClass1 {

    @Test
    public void verify_Account_Registration() {
        logger.info("****** Starting Test TC001_AccountRegistrationTest ********");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("****** Clicked On My Account ********");

        hp.clickRegister();
        logger.info("****** Clicked On Register ********");

        AccountRegistration acctregister = new AccountRegistration(driver);

        logger.info("****** Providing Information ********");

        acctregister.setFirstName(randomeString().toUpperCase());
        acctregister.setLastName(randomeString().toUpperCase());
        acctregister.setEmail(randomeString() + "@gmail.com");

        String password = randomeAlphaNumeric();

        acctregister.setPassword(password);
        acctregister.setConfirmPassword(password);

        acctregister.clickOnPolicy();
        logger.info("****** Clicked On Policy ********");

        acctregister.clickContinue();
        logger.info("****** Clicked Continue Button ********");

        try {
            String confmsg = acctregister.getConfirmationMsg();
            logger.info("****** Confirmation message: " + confmsg + " ********");

            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
            logger.info("****** Account Registration Assertion Passed ********");

        } catch (Exception e) {
            logger.error("❌ Account Registration failed: " + e.getMessage(), e);
            Assert.fail("❌ Test failed due to exception: " + e.getMessage());
        }
    }
}
