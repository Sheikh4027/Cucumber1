package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
public WebDriver driver;

private By LogInClick = By.xpath("//a//span[contains(text(),'Login')]");
private  By Title = By.xpath("//h2[contains(text(),'Featured Courses')]");
private  By NavBar= By.xpath("//ul[@class='nav navbar-nav navbar-right']");
private By Banner = By.xpath("//p[contains(text(),'Learn Hot tools like Selenium, Appium, JMeter, Soa')]");
//private By selfPaced = By.xpath("//h3[contains(text(),'Self Paced online Training')]");	

public LandingPage(WebDriver driver) 
		{
			  this.driver=driver;	
			}


	
public LoginPage LogInClick()
	{
	 driver.findElement(LogInClick).click();
	 LoginPage lp = new LoginPage(driver);
	 return lp;
	 
	 
	}

public WebElement getTitle()
{
	return driver.findElement(Title);
}

public WebElement getNavBar()
{
	return driver.findElement(NavBar);
}

public WebElement getBannerName()
{
	 return driver.findElement(Banner);
}






}
