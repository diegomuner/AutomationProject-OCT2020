package com.automationoct.webpages.testwebpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLoginPage {
	private WebDriver driver;

//URL
//private static String PAGE_URL="https://www.google.com";

	// Locators
	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;
	
	@FindBy(how = How.ID, using = "button")
	private WebElement loginButton;

	// Constructor
	public TestLoginPage(WebDriver driver) {
		this.setDriver(driver);
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}



	

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
