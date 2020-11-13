package com.automationoct.webpages.belong;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BelongTestPage {


	
	private WebDriver driver;
	
	//URL
	//private static String PAGE_URL="";

		// Locators
		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[1]/div[1]/div/div[2]/nav/div[2]/ul[1]/li[2]/a")
		private WebElement listAHome;
		
		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div[3]/a[1]")
		private WebElement addYourHome;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/form/form/div/div/div/button[1]/span/div")
		private WebElement oneHome;
		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[1]/div/div/form/form/div/div/div/button[2]/span/div")
		private WebElement fewHomes;       
		@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/form/div[2]/div[2]/button")
		private WebElement nextButton1;
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"addressForm\"]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/div[2]/input")
		private WebElement addressField;

		@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div")
		private WebElement notThereYet;
		
		
		
		@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div/div[2]/div/div/div/button[1]/span/div")
		private WebElement singleFamily;
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div/form/div[2]/div[2]/button")
		private WebElement nextButton2;
		
		
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[1]/div/div[1]/div/div/button[3]/div/div")
		private WebElement quiteAverageButton;
		
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[1]/div/div[2]/div/div/div/div/div/button")
		private WebElement appliancesAgeField;
		
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[3]/div[2]/div/div/div/button[2]/div/div")
		private WebElement currentlyFurnishedNo;
		
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[2]/div[2]/div/div/div/button[2]")
		private WebElement renovatedHomeNo;
		
		
	
		
		

	
		// Constructor
		public BelongTestPage(WebDriver driver) {
			this.setDriver(driver);
			// driver.get(PAGE_URL);
			// Initialize Elements
			PageFactory.initElements(driver, this);
		}

		public void startRentAHome() {
			listAHome.click();
			addYourHome.click();
		
		}

		public void numberOfHomes(String text) {
			if (text=="one") {
				oneHome.click();
			}
			else if (text=="few") {
				fewHomes.click();
			}
		}
	
		public void populateSinglePropertyInformation(String text) {
			addressField.sendKeys(text);
			
		}
		
		public void clickNext() {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/form/div[2]/div[2]/button")));

			nextButton1.click();
		}
		public void notThereYetValidation() {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div")));
			String actualString=notThereYet.getText();
			assertTrue(actualString.contains("But we're not there yet."));
			
		}
		
		
		public void homeTypeSelect(String text) {
			if (text=="singleFamily") {
				singleFamily.click();
			}
			
		}
		
		public void singleFamilyPopulateForm() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[3]/div[2]/div/div/div/button[2]/div/div")));
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[3]/div[2]/div/div/div/button[2]/div/div")).click();
			driver.findElement(By.xpath("//*[@id=\"downshift-0-toggle-button\"]")).click();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.RETURN).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"downshift-1-toggle-button\"]")).click();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.RETURN).perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"downshift-2-toggle-button\"]")).click();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
			new Actions(driver).sendKeys(Keys.RETURN).perform();
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[4]/div/div[1]/div[4]/div/div/div/div[2]/input")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[4]/div/div[1]/div[4]/div/div/div/div[2]/input")).sendKeys("44");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/div/div/form/form/div[5]/div[2]/div/div/div/button[2]/div/div")).click();
			Thread.sleep(1000);
			nextButton2.click();
			
			
		}
		
		
		public void alreadyLoggedIn() {
			
			try {
			    WebElement popUp = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[3]/div/button/div"));
			    popUp.click();  
			} catch(NoSuchElementException | StaleElementReferenceException e) {
			    Reporter.log("Impossible to click the pop-up. Reason: " + e.toString());
			}
				
			
			
		}
		
		
		public void populateHomeCondition() throws InterruptedException {
			
		Thread.sleep(5000);
			quiteAverageButton.click();
			appliancesAgeField.click();
			new Actions(driver).sendKeys(Keys.RETURN).perform();
			Thread.sleep(1000);
			currentlyFurnishedNo.click();
			renovatedHomeNo.click();
			nextButton1.click();
			
		}
		
		
		public WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
	}

