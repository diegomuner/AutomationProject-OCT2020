
package com.automationoct.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationoct.helpers.BaseTest;
import com.automationoct.webpages.GooglePage;

public class Sample extends BaseTest {

	
	
	@Test

	public void GoogleSearch() throws InterruptedException {
		driver.get(testEnvironment.url());
		GooglePage home = new GooglePage(driver, wait);
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		home.searchFor("zambicooking");
		Reporter.log("Logramos Buscar a Zambicooking");
		home.click1stResult();
		Reporter.log("Estamos en Zambicooking!!!");

	}

	@Test

	public void TestTest() throws InterruptedException {

		driver.get(testEnvironment.url());
		
		GooglePage home = new GooglePage(driver, wait);
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		home.searchFor("beach");
		Reporter.log("Logramos Buscar beach");

	}

	@Test
	public void TestTestTest() throws InterruptedException {

		driver.get(testEnvironment.url());
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		GooglePage home = new GooglePage(driver, wait);
		home.searchFor("samoyed");
		Reporter.log("Logramos Buscar samoyed");

	}

}
