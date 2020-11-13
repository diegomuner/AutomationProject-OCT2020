package com.automationoct.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automationoct.helpers.NoWebDriverTest;
import com.automationoct.utilities.CSVReaderClass;
import com.automationoct.utilities.JsonReader;
import com.automationoct.utilities.ReadCsvFiles;
import com.automationoct.utilities.XlsReader;

public class ReadersTests extends NoWebDriverTest {
	
	
	
	// CSV TESTS
	@Test
	public void TestCsvReaderClass1() throws Exception {
		
		ReadCsvFiles.readCsv("100sales.csv");
		Reporter.log("1000sales.csv procesado perfecto!");
		CSVReaderClass.readCsv("SampleCSVFile.csv");
		Reporter.log("Sample.csv procesado perfecto!");
		CSVReaderClass.printCSV("100sales.csv");
		Reporter.log("printCSV Method va bien");
		
		}
	// XLS TESTS
	@Test
	public void TestXlsReader1() throws Exception {
		XlsReader.parseXLSX("Financial Sample.xlsx");
		Reporter.log("xls todo joya");
		XlsReader.readXls("Financial Sample.xlsx");
		Reporter.log("xls todo joya");
		
	}
	
	// JSON TESTS
	@Test
	public void TestJsonReader1() throws Exception {
		JsonReader.readJson("usernames.json");
		Reporter.log("Json Reader works too");
		
		
	}
	
		
}
