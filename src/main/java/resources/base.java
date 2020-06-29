package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	

public WebDriver driver;	

public Properties prop;
public WebDriver initializeDriver() throws IOException	
{
	
 prop =new Properties();	
 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
 prop.load(fis);
 //String browserName = prop.getProperty("browser");  // for running in locally selected browser style.
 String browserName = System.getProperty("browser"); // for running in jenkins or mvn style.
 System.out.println(browserName);

 
 if(browserName.contains("chrome"))
 {
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmad\\Downloads\\Documents\\chromedriver.exe");
 ChromeOptions options = new ChromeOptions();
 if(browserName.contains("headless"))
 {
 options.addArguments("headless");
 }
 driver = new ChromeDriver(options);

 }

 
 
 
/* if (browserName.equals("chrome"))
 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmad\\Downloads\\Documents\\chromedriver.exe");
		
    driver =new ChromeDriver();
 }
*/

 else if(browserName.equals("firefox"))
 {
	 System.setProperty("Webdriver.gecko.driver", "C:\\Users\\ahmad\\Downloads\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 
	 
 }
 else if (browserName.equals("IE"))
 {
	 System.setProperty("Webdriver.ie.driver", "C:\\Users\\ahmad\\Downloads\\IEDriverServer_x64_3.150.1.exe");
	 driver = new InternetExplorerDriver();
 }
 

 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 return driver;
 
 
 }


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}







	
}
