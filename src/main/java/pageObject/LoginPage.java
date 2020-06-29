package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
public WebDriver driver;

public LoginPage(WebDriver driver) 
{
	  this.driver=driver;	
	}


 By Email = By.id("user_email");
 By Password =By.id("user_password");
By LogIn = By.name("commit");
//private By forgotPass=By.xpath("//a[@class='link-below-button']");
	

	public WebElement Email()
	{
		return driver.findElement(Email);
	}


public WebElement Password()
{
	return driver.findElement(Password);
}


public WebElement LogIn()
{
	return driver.findElement(LogIn);
}


/*
public ForgotPass forgotPass()
{
	driver.findElement(forgotPass).click();
	ForgotPass fp = new ForgotPass(driver);
	return fp;
}

*/


}
