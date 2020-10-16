package com.automationoct;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;

public class CustomListener implements ITestListener {
	private int mcount = 0;
	WebDriver driver = null;
	String filePath = "C:\\users\\diego\\Desktop\\";

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("***** Error " + tr.getName() + " test has failed *****");
		String methodName = tr.getName().toString().trim();
		WebDriver driver = (WebDriver) tr.getTestContext().getAttribute("webDriver");
		takeScreenShot(methodName, driver);

	}

	public void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log(tr.getName() + "--Test method skipped\n");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		log(tr.getName() + "--Test method success\n");

		tr = Reporter.getCurrentTestResult();
		tr.setAttribute("requirement", "CALC-1234"); // Xray will try to create a link to this requirement issue
		tr.setAttribute("test", "CALC-2"); // Xray will try to find this Test issue and report result against it
		tr.setAttribute("labels", "core addition"); // Xray will add this(ese) label(s) to the associated Test issue
		System.out.print(tr);
	}

	private void log(String string) {
		System.out.print(string);
		if (++mcount % 40 == 0) {
			System.out.println("");
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext tr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext tr) {
		// TODO Auto-generated method stub

	}

}
