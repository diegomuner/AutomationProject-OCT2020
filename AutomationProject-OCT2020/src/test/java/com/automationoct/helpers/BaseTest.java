package com.automationoct.helpers;

import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automationoct.Environment;
import com.automationoct.Reporters;

@Listeners({ com.automationoct.CustomListener.class })

public class BaseTest {

	protected WebDriver driver;
	protected Environment testEnvironment;
	protected WebDriverWait wait;
	// Reporters testReporter;
	
	@BeforeMethod

	@Parameters({ "environment" })
	//public void setUp(ITestContext context, @Optional("qa") String environment) {
	public void setUp(@Optional("qa") String environment) {	
		
		ConfigFactory.setProperty("env", environment);
		
		System.out.println(ConfigFactory.getProperties().getProperty("env"));
		System.out.println("classpath:${env}.properties".replace("${env}", ConfigFactory.getProperties().getProperty("env")));




		testEnvironment = ConfigFactory.create(Environment.class);
		
		//testReporter = ConfigFactory.create(Reporters.class);
		System.out.println("baseTestBeforeClass called");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		System.out.print(testEnvironment);
		//System.out.print(testReporter.reporterName());
		if (testEnvironment.url() == null) {

			System.out.println("URL WAS NOT FOUUND.. closing");
			driver.quit();

		} else {
			this.driver = new ChromeDriver();
			this.wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(testEnvironment.url());
			driver.manage().window().maximize();
		//	context.setAttribute("webDriver", driver);
			System.out.println("Webdriver created and added to context");
		}
	}

	@AfterMethod

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
