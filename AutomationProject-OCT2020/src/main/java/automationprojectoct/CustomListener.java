package automationprojectoct;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.apache.commons.io.FileUtils;




public class CustomListener implements ITestListener{
	   private int m_count = 0;
	   WebDriver driver=null;
		String filePath = "C:\\users\\diego\\Desktop\\";

	/*   
	   @Override
	   public void onTestFailure(ITestResult tr) {
	      log(tr.getName()+ "--Test method failed\n");
	     // File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //codigo para copiar el screenshot en una localizacion deseada
	    //FileUtils.copyFile(scrFile, new File("C:\\Screenshot\\google.jpg"));
*/	    
	   @Override
	   public void onTestFailure(ITestResult tr) { 
	    	System.out.println("***** Error "+tr.getName()+" test has failed *****");
	    	String methodName=tr.getName().toString().trim();
	      //  ITestContext context = tr.getTestContext();
	        WebDriver driver = (WebDriver)tr.getTestContext().getAttribute("webDriver");
	    	takeScreenShot(methodName, driver);
	    }
	    
	    public void takeScreenShot(String methodName, WebDriver driver) {
	    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //The below method will save the screen shot in d drive with test method name 
	            try {
					FileUtils.copyFile(scrFile, new File(filePath+ methodName +".png"));
					System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }      
	      
	    
	   @Override
	   public void onTestSkipped(ITestResult tr) {
	      log(tr.getName()+ "--Test method skipped\n");
	   }
		 
	   
	   @Override
	   public void onTestSuccess(ITestResult tr) {
	      log(tr.getName()+ "--Test method success\n");
	   }
	   
	   private void log(String string) {
		      System.out.print(string);
		      if (++m_count % 40 == 0) {
		         System.out.println("");
		      }
		   }
	   
	   
	   
	   
	   
	    
	   
	   
}
