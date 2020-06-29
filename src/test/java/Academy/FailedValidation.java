package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class FailedValidation extends base {

public	static Logger Log = LogManager.getLogger(base.class.getName());	
public WebDriver driver;

@BeforeTest
public void initializetion() throws IOException
{
	driver = initializeDriver();
	
	Log.info("driver is initialize on failed validation page");
	
	driver.get(prop.getProperty("url"));
	
}
	
@Test

public void basePageNavigation1()throws IOException
{
	
	
	LandingPage lg= new LandingPage(driver);
	//l.LogInClick().click();
	//Assert.assertEquals(lg.Title().getText(), "FEATURED COURSES1");
	
	
	
	//Assert.assertTrue(l.NavBar().isDisplayed());
	
	//Log.info("successfully validated");
	
	Assert.assertFalse(lg.getNavBar().isDisplayed());  //just checking with false to fail the test.
	Log.error("Intentional");

	
}

@AfterTest
public void closingWindow()
{
	driver.close();
	Log.debug("I'm debugging");
}







}
