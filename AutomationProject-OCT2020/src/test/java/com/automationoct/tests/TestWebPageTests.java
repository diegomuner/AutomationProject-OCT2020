package com.automationoct.tests;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationoct.dataproviders.TestWebPageDataProvider;
import com.automationoct.helpers.TestWebPageHelper;
import com.automationoct.webpages.testwebpage.TestLoginPage;

public class TestWebPageTests extends TestWebPageHelper {

	@Test(invocationCount = 1, dataProvider = "data1", dataProviderClass = TestWebPageDataProvider.class)
    public void LoginTestPage(String userName, String password) throws InterruptedException {
   
       

        String url = "C://login.html";
        driver.get(url);
        Thread.sleep(1000);
    

        
		// We use javascript document.readyState to wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

		//
		Reporter.log("estamos en la login page de pagina test");
		TestLoginPage home = new TestLoginPage(driver);
		home.verifyPageLoaded();
		home.login(userName, password);

	}
/*
	@Test(invocationCount = 1, dataProvider = "data3", dataProviderClass = TestWebPageDataProvider.class)

	public void LoginTestPageUsingJsonFile(String data) throws InterruptedException {
		String credentials[] = data.split(",");

		driver.get(testEnvironment.urlTestPage());

		// We use javascript document.readyState to wait
		// @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

		//
		Reporter.log("we are in test login page");
		TestLoginPage home = new TestLoginPage(driver);
		home.verifyPageLoaded();
		home.login(credentials[0], credentials[1]);

	}
*/
}
