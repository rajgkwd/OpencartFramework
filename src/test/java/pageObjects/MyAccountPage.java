package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//input[@id='input-email']")
	WebElement msgHeading;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
}
