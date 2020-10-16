package com.automationoct.tests;

import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automationoct.Environment;
import com.automationoct.Reporters;

@Listeners({ com.automationoct.CustomListener.class })

public class BaseTest {

	WebDriver driver;
	Environment testEnvironment;
	Reporters testReporter;

	@BeforeClass

	@Parameters({ "environment","reporter" })
	public void setUp(ITestContext context, @Optional("qa") String environment,@Optional("testNg") String reporter) {

		ConfigFactory.setProperty("env", environment);
		testEnvironment = ConfigFactory.create(Environment.class);
		ConfigFactory.setProperty("rep", reporter);
		testReporter = ConfigFactory.create(Reporters.class);
		
		
		
		System.out.println("baseTestBeforeClass called");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\diego\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.out.print(testEnvironment);
		System.out.print(testReporter.reporterName());
		if (testEnvironment.url() == null) {

			System.out.println("URL WAS NOT FOUUND.. closing");
			driver.quit();

		} else {
			this.driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(testEnvironment.url());
			driver.manage().window().maximize();
			context.setAttribute("webDriver", driver);
			System.out.println("Webdriver created and added to context");
		}
	}

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
