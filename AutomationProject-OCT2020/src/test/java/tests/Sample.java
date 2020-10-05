

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import webpages.GooglePage;


public class Sample extends BaseTest {
	

	

@Test

	public void GoogleSearch() throws InterruptedException{
		

	GooglePage home = new GooglePage(driver);
	home.searchFor("zambicooking");
	System.out.println("Logramos Buscar a Zambicooking");
	home.click1stResult();
	System.out.println("Estamos en Zambicooking!!!");
	
	
	}
}
