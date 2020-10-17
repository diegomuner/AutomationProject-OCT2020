package com.automationoct.helpers;

import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automationoct.Environment;
import com.automationoct.Reporters;

@Listeners({ com.automationoct.CustomListener.class })

public class NoWebDriverTest  {

	protected WebDriver driver;
	protected Environment testEnvironment;
	Reporters testReporter;

	@BeforeClass


	public void setUp() {
  System.out.print("No WebDriver Test");
		
	}

	@AfterClass

	public void tearDown() {
		
	

	}

	public WebDriver getDriver() {

		return driver;

	}
		
	


	}


