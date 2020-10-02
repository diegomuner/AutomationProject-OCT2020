package Diego.AutomationProject_OCT2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Sample {
	
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\diego\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
	
	}
	@Test
	
	public void test1() throws InterruptedException{
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		//driver.get("\"https://www.google.com/");
		driver.wait(10);
		
	
	}
}
