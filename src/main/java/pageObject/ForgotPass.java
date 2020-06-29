package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPass {
	
	
public WebDriver driver;



By forgotPass= By.xpath("//a[@class='link-below-button']");
By Email = By.id("user_email");
By SendInstructions = By.cssSelector("[type='submit']");

public ForgotPass(WebDriver driver) 
{
	  this.driver=driver;	
	}



public WebElement Email()
{
	return  driver.findElement(Email);
	
}

public WebElement SendInstructions()
{
  	return driver.findElement(SendInstructions);
}



}
