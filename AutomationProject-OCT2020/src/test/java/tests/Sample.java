

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import webpages.GoogleHomePage;


public class Sample extends BaseTest {
	

	

@Test

	public void GoogleSearch() throws InterruptedException{
		
	Thread.sleep(10000);
	System.out.println("Thread Sleept 10 s");
	GoogleHomePage home = new GoogleHomePage(driver);
	home.searchFor("zambicooking");
	Thread.sleep(10000);
	System.out.println("Logramos Buscar a Zambicooking");
	home.click1stResult();
	
	}
}
