package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({automationprojectoct.CustomListener.class}) 



public class BaseTest {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp(ITestContext context) {
		//Browser Setup
		System.out.println("baseTestBeforeTest called");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		context.setAttribute("webDriver", driver);
		System.out.println("Webdriver created and added to context");
		
		
	}
	@AfterTest
	public void tearDown() {
		//Closing Browser and Driver
		 if(driver != null){
	            driver.quit();
	            System.out.println("Driver was instantiated. Quitting..");
	        }else{
	            System.out.println("Driver was null so nothing to do");
	        }
	    }
	
	
	public WebDriver getDriver() {
		
		return driver;
		
	}
	
	
  @Test
  public void test1() throws InterruptedException {
	  
  
	  
  }
}
