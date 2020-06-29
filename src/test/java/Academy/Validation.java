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

public class Validation extends base {

public	static Logger Log = LogManager.getLogger(base.class.getName());	
public WebDriver driver;
LandingPage l;

@BeforeTest
public void initializetion() throws IOException
{
	driver = initializeDriver();
	Log.info("driver is initialize");
	driver.get(prop.getProperty("url"));
	Log.info("page is loadded");
}
	
@Test

public void basePageNavigation()throws IOException
{
	
	
	
	 l= new LandingPage(driver);
	//l.LogInClick().click();
	Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
	
	Assert.assertTrue(l.getNavBar().isDisplayed());
	
	Log.info("successfully validated");
	
	//Assert.assertFalse(l.NavBar().isDisplayed());  //just checking with false to fail the test.
	
	Log.error("Intentional");
	//l.NavBar().isDisplayed();
	
}

@Test
public void ValidetingBanners()throws IOException
{
	Assert.assertEquals(l.getBannerName().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
}


@AfterTest
public void closingWindow()
{
	driver.close();
	Log.debug("I'm debugging");
}



}
