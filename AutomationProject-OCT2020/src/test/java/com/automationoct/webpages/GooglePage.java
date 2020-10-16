package com.automationoct.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	private WebDriver driver;

//URL
//private static String PAGE_URL="https://www.google.com";

	// Locators
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchField;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Melanie (@zambicooking) • Instagram photos and videos")
	private WebElement firstResult;

	// Constructor
	public GooglePage(WebDriver driver) {
		this.setDriver(driver);
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
}