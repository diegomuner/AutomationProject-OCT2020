package webpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	private WebDriver driver;
	
	//URL
	private static String PAGE_URL="https://www.google.com";
	
	//Locators
 //@FindBy(id = "lst-ib")
	//WebElement searchField;
 
 
 @FindBy(how = How.NAME, using = "q" )
 WebElement searchField;
 
 
 
 @FindBy(how = How.CLASS_NAME, using= "h3")
 WebElement firstResult;
 
 
 

 
 
 //Constructor
 public GoogleHomePage(WebDriver driver){
     this.driver=driver;
     driver.get(PAGE_URL);
     //Initialise Elements
     PageFactory.initElements(driver, this);
 }


 public void searchFor(String text) {
	 searchField.sendKeys(text);
     searchField.submit();
 }
	
 public void click1stResult() {
	 firstResult.click();
	 
	 
 }
}
