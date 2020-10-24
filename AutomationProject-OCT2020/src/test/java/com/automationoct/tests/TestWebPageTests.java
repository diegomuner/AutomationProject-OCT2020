package com.automationoct.tests;


import org.testng.Reporter;
import org.testng.annotations.Test;


import com.automationoct.helpers.TestWebPageHelper;


public class TestWebPageTests extends TestWebPageHelper {

	

	@Test

	public void LoginTestPage() throws InterruptedException {
		driver.get(testEnvironment.urlTestPage());
		
		Reporter.log("estamos en la login page de pagina test");
		Thread.sleep(3312313);
	}

	


}
