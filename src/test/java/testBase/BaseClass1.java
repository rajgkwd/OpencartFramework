package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass1 
{
	
	public WebDriver driver;
	public  Logger logger;    //log4j 2
	public Properties p;
	
	
	
	@BeforeClass
	public void SetUp() throws IOException 
	{
		
		FileReader file=new FileReader("./src//test//resource//ConfigProperties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
				return generatedstring;
	}
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(5);
				return generatednumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(5);
				return (generatedstring+"@"+generatednumber);
	}
	
	
	
	
}
