package com.automationoct.helpers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automationoct.Environment;
import com.automationoct.Reporters;

// @Listeners({ com.automationoct.CustomListener.class })

public class TestWebPageHelper  {

	protected WebDriver driver;
	protected Environment testEnvironment;


	@BeforeClass

	//@Parameters({ "environment" })
	//public void setUp(ITestContext context, @Optional("qa") String environment) {
		
	public void setUp() {

		//ConfigFactory.setProperty("env", environment);
		//testEnvironment = ConfigFactory.create(Environment.class);
		//System.out.println("baseTestBeforeClass called");
		//System.out.println(testEnvironment);
		System.setProperty("webdriver.chrome.driver", "E:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		     

		//if (testEnvironment.urlTestPage() == null) {

		//	System.out.println("URL WAS NOT FOUUND.. closing");
		//	driver.quit();

		//} else {
			this.driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// driver.get(testEnvironment.urlTestPage());
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			//context.setAttribute("webDriver", driver);
			System.out.println("Webdriver created and added to context");
		}
	//}

	@AfterClass

	public void tearDown() {
		// Closing Browser and Driver
		if (driver != null) {
			driver.quit();
			System.out.println("Driver was instantiated. Quitting..");
		} else {
			System.out.println("Driver was null so nothing to do");
		}

	}

	public WebDriver getDriver() {

		return driver;

	}
		
	}


