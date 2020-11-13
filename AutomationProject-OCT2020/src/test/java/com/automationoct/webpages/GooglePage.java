package com.automationoct.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
	private WebDriver driver;
	private WebDriverWait wait;

//URL
//private static String PAGE_URL="https://www.google.com";

	// Locators
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchField;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Recetas faciles (@zambicooking) • Instagram photos and videos")
	private WebElement firstResult;

	// Constructor
	public GooglePage(WebDriver driver, WebDriverWait wait) {
		this.setDriver(driver);
		this.setWebdriverWait(wait);
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	 
	}

	public void searchFor(String text) {
		searchField.sendKeys(text);
		searchField.submit();
	}

	public void click1stResult() {
		firstResult.click();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setWebdriverWait(WebDriverWait wait) {
		this.wait = wait;
		
	}
}
