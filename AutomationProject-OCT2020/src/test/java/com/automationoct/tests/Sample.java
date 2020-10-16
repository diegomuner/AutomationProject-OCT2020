
package com.automationoct.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.automationoct.webpages.GooglePage;

public class Sample extends BaseTest {

	

	@Test

	public void GoogleSearch() throws InterruptedException {
		driver.get(testEnvironment.url());
		GooglePage home = new GooglePage(driver);
		home.searchFor("zambicooking");
		//testReporter.reporterName().log("Logramos Buscar a Zambicooking");
		Reporter.log("Logramos Buscar a Zambicooking");
		home.click1stResult();
		Reporter.log("Estamos en Zambicooking!!!");

	}

	@Test

	public void TestTest() throws InterruptedException {

		driver.get(testEnvironment.url());
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		GooglePage home = new GooglePage(driver);
		home.searchFor("beach");
		Reporter.log("Logramos Buscar beach");

	}

	@Test
	public void TestTestTest() throws InterruptedException {

		driver.get(testEnvironment.url());
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		GooglePage home = new GooglePage(driver);
		home.searchFor("samoyed");
		Reporter.log("Logramos Buscar samoyed");

	}

}
