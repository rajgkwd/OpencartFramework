package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	public HomePage (WebDriver driver)                   // This is Constructor
	{
		super(driver);
	}
	
	@FindBy (xpath= "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy (xpath= "//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy (xpath= "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Login;
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	public void clickRegister()
	{
		Register.click();
	}
	public void clickLogin()
	{
		Login.click();
	}
	
}
