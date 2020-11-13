package com.automationoct.tests;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationoct.helpers.BaseTest;
import com.automationoct.webpages.GooglePage;

@Listeners({ com.automationoct.CustomListener.class })
public class EnvironmentTest extends BaseTest {

	public void functionalTest() {
		System.out.println(testEnvironment.url());
		System.out.println(testEnvironment.getDBHostname());
		System.out.println(testEnvironment.getDBPassword());
	}

	@Test

	public void TestTestTest43() throws InterruptedException {

		driver.get(testEnvironment.url());
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		GooglePage home = new GooglePage(driver, wait);
		home.searchFor("samoyed");
		Reporter.log("Logramos Buscar samoyed");

	}

	/*
	 * @DataProvider (name = "data-provider") public Object[][] dpMethod(){ return
	 * new Object[][] {{"First-Value"}, {"Second-Value"}}; }
	 * 
	 * @Test (dataProvider = "data-provider") public void myTest (String val) {
	 * System.out.println("Passed Parameter Is : " + val); }
	 * 
	 */

}