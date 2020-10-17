package com.automationoct.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationoct.helpers.NoWebDriverTest;
import com.automationoct.utilities.CSVReaderClass;
import com.automationoct.utilities.ReadCsvFiles;




public class ReadersTests extends NoWebDriverTest {
	
	
	
	// CSV TEST
	@Test
	public void TestCsvReaderClass1() throws Exception {
		
		ReadCsvFiles.readCsv("100sales.csv");
		Reporter.log("1000sales.csv procesado perfecto!");
		CSVReaderClass.readCsv("SampleCSVFile.csv");
		Reporter.log("Sample.csv procesado perfecto!");
		
		
	}

	
	
	
	
	
	
}
