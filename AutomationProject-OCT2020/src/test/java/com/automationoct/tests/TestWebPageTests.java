package com.automationoct.tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.automationoct.helpers.TestWebPageHelper;
import com.automationoct.webpages.testwebpage.TestLoginPage;


public class TestWebPageTests extends TestWebPageHelper {

	

	@Test (invocationCount=20)

	public void LoginTestPage() throws InterruptedException {
		driver.get(testEnvironment.urlTestPage());
		
		// We use javascript document.readyState to wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until( driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		
		//
		Reporter.log("estamos en la login page de pagina test");
	    TestLoginPage home= new TestLoginPage(driver);
	    home.verifyPageLoaded();
	    home.login("Diego", "alohaway");
	    
	    
		
	}

	


}
