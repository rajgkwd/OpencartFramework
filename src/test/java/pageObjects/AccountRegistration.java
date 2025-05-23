package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for Account Registration Page
 * Applies PageFactory for element initialization and Java naming conventions.
 */
public class AccountRegistration extends BasePage {

    // Constructor
    public AccountRegistration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // ✅ Must initialize @FindBy elements
    }

    // WebElements using PageFactory
    @FindBy(id = "input-firstname")
    private WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    private WebElement txtLastName;

    @FindBy(id = "input-email")
    private WebElement txtEmail;

    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;

    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(id = "input-confirm")
    private WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    private WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

    // Page Actions (Setters)
    public void setFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        txtTelephone.sendKeys(telephone);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void agreeToPolicy() {
        if (!chkPolicy.isSelected()) {
            chkPolicy.click();
        }
    }

    public void clickContinue() {
        btnContinue.click();
    }

    // Get Confirmation Message
    public String getConfirmationMsg() {
        try {
            return msgConfirmation.getText();
        } catch (Exception e) {
            return "❌ Error retrieving confirmation message: " + e.getMessage();
        }
    }

	public void clickOnPolicy() {
		// TODO Auto-generated method stub
		
	}
}
