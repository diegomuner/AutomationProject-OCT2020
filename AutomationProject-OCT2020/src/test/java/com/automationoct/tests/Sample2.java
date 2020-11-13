
package com.automationoct.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationoct.helpers.BaseTest;
import com.automationoct.webpages.belong.BelongTestPage; //Import each page used
import com.automationoct.webpages.belong.NewUserModal;

public class Sample2 extends BaseTest {

	@Test

	public void RentWorkflowInvalidAddress() throws InterruptedException {
		driver.get("https://staging.bln.hm/homeowners"); // being the starting point in the file
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		BelongTestPage belongPage = new BelongTestPage(driver);
		belongPage.startRentAHome();
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		belongPage.numberOfHomes("one");
		belongPage.clickNext();
		belongPage.populateSinglePropertyInformation("5555 Hamner Avenue");
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.RETURN).perform();
		Thread.sleep(1000);
		belongPage.clickNext();
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		belongPage.notThereYetValidation();

	}

	@DataProvider(name = "dataTest")
	public Object[][] getUserData2() {
		return new Object[][] { { "test142273", "testt4900221", "tes6ttest1320@test.com", "1234567890" } };
	}

	@Test(dataProvider = "dataTest")
	public void RentWorkflowValidAddress(String firstName, String lastName, String email, String phone)
			throws InterruptedException {
		driver.get("https://staging.bln.hm/homeowners"); // being the starting point in the file
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		BelongTestPage belongPage = new BelongTestPage(driver);
		belongPage.startRentAHome();
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		belongPage.numberOfHomes("one");
		belongPage.clickNext();
		belongPage.populateSinglePropertyInformation("525 Oak Grove Avenue, Menlo Park");
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.RETURN).perform();
		Thread.sleep(1000);
		belongPage.clickNext();
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		NewUserModal newUser = new NewUserModal(driver);
		newUser.createNewUser(firstName, lastName, email, phone);
		Thread.sleep(2000);
		belongPage.alreadyLoggedIn();
		
		belongPage.singleFamilyPopulateForm();
		
		belongPage.populateHomeCondition();

	}

}