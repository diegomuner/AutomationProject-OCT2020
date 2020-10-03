package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		//Browser Setup
		System.out.println("baseTestBeforeTest called");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
		
	}
	@AfterTest
	public void tearDown() {
		//Closing Browser and Driver
		System.out.println("Closing Browser - tearDown method called");
		driver.close();
	}
	
	
  @Test
  public void test1() throws InterruptedException {
	  
	Thread.sleep(10000);
	  
	  
	  
  }
}
