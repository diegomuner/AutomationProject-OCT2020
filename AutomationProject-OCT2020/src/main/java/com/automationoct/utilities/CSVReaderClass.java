package com.automationoct.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderClass {

	private static CSVReader csvReader;
	static String[] csvCell;
	


	public static void readCsv (String CsvFilePath) throws CsvValidationException, IOException {

		// Get scanner instance
		Scanner scanner = new Scanner(new File(CsvFilePath));

		// Set the delimiter used in file
		scanner.useDelimiter(";");

		// Get all tokens and store them in some data structure
		// we just print them
		while (scanner.hasNext()) {
			System.out.print(scanner.next() + "|");
		}

		// close the scanner
		scanner.close();


	}
/*
	private static void printCSV() throws IOException, CsvValidationException {

		csvReader = new CSVReader(new FileReader("SampleCSVFile.csv"));

		while ((csvCell = csvReader.readNext()) != null) {

			String val1 = csvCell[0];

			System.out.print(val1);
		}

	}
*/
}