package com.automationoct.webpages.belong;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class NewUserModal {

	private WebDriver driver;

	// URL
	// private static String PAGE_URL="";

	// Locators
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/form/div/div/div[2]/div[1]/div[1]/div/div/div[2]/input")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/form/div/div/div[2]/div[1]/div[2]/div/div/div[2]/input")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/form/div/div/div[2]/div[2]/div/div[2]/input")
	private WebElement emailAddress;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/form/div/div/div[2]/div[3]/div/div[2]/input")
	private WebElement phoneNumber;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/form/div/div/button")
	private WebElement continueButton;

	// Constructor
	public NewUserModal(WebDriver driver) {
		this.setDriver(driver);
		// driver.get(PAGE_URL);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	}

	public void createNewUser(String firstName1, String lastName1, String email1, String phone1) {
		firstName.sendKeys(firstName1);
		lastName.sendKeys(lastName1);
		emailAddress.sendKeys(email1);
		phoneNumber.sendKeys(phone1);
		continueButton.click();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
