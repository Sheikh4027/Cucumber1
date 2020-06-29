package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPass;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;


public class HomePage extends base {
	
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());

	

@Test(dataProvider = "getdata")

public void basePageNavigation(String userName, String password, String text) throws IOException
{
	driver =initializeDriver();
	 driver.get(prop.getProperty("url"));
	
	
	LandingPage l= new LandingPage(driver);
	LoginPage lp=l.LogInClick();
	
	
	//LoginPage lp = new LoginPage(driver);
	
	lp.Email().sendKeys(userName);
	lp.Password().sendKeys(password);
	lp.LogIn().click();	
    log.info(text);
	
	
	/*
	ForgotPass fp = lp.forgotPass();
	Log.info("Clciked on forgotPassword");
	
	fp.Email().sendKeys("tufail");
	
	
	fp.SendInstructions().click();
	Log.error("This Test didnot run on the mvn test");
	
	*/
	
	
	}



@AfterTest
public void tearDown()

{

   driver.close();

}






@DataProvider
public Object[][] getdata()

{
	
	Object[][] data = new Object[2][3];            // creating Object claas for dataprovider.
	                                             // array count start from 0. but test n value start [1][1].
	                                            //test to run =[1],  value we sending =[2].
	                                      // as many test we run as many windows will open. here [2] =2 windows.
	data[0][0] = "sheikh123@gmail.com" ;
	data [0][1]= "wwwww11123";
	data [0][2]= "Valid User";
	
    data[1][0] = "tufail539@gmail.com" ;
	data [1][1]= "pppww12345";
	data[1][2]= "Invalid User";
	
	return data;
	
	
}


}
