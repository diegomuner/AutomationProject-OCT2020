package com.automationoct.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationoct.utilities.CSVReaderClass;
import com.automationoct.utilities.ReadCsvFiles;
import com.opencsv.exceptions.CsvValidationException;

public class ReadersTests extends BaseTest {
	
	
	
	// CSV TEST
	@Test
	public void TestCsvReaderClass1() throws Exception {
		
		// CSVReaderClass.readCSV("SampleCSVFile.csv");
		ReadCsvFiles.readCSV("SampleCSVFile.csv");
		
		
		
		
		
	}

	
	
	
	
	
	
}
