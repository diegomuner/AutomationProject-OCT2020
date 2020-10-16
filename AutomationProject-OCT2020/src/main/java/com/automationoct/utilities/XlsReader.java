package com.automationoct.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {

	public static void main(String[] args) throws IOException {
		// Path of the excel file

		FileInputStream fs = new FileInputStream("Financial Sample.xlsx");
		try (// Creating a workbook
				XSSFWorkbook workbook = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Print C-3
			Row row3 = sheet.getRow(2);
			Cell cell3 = row3.getCell(2);
			System.out.println(sheet.getRow(2).getCell(2));

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + " ");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + " ");
						break;
					}
				}
				System.out.println("");
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Row row = sheet.getRow(0); Cell cell = row.getCell(0);
	 * System.out.println(sheet.getRow(0).getCell(0)); Row row1 = sheet.getRow(1);
	 * Cell cell1 = row1.getCell(1); System.out.println(sheet.getRow(0).getCell(1));
	 * Row row2 = sheet.getRow(1); Cell cell2 = row2.getCell(1);
	 * System.out.println(sheet.getRow(1).getCell(0)); Row row3 = sheet.getRow(1);
	 * Cell cell3 = row3.getCell(1); System.out.println(sheet.getRow(1).getCell(1));
	 * //String cellval = cell.getStringCellValue(); //System.out.println(cellval);
	 * }
	 * 
	 */

	public static void parseXLSX() {

		String pathToXLSX = "Financial Sample.xlsx";
		File file = new File(pathToXLSX);

		FileInputStream in = null;

		try {
			in = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int rowNumber = sheet.getLastRowNum() + 1;
				for (int j = 1; j < rowNumber; j++) {
					Iterator<Cell> it = sheet.getRow(j).cellIterator();
					while (it.hasNext()) {
						System.out.println(it.next().toString());
					}
				}
			}
		} catch (IOException ex) {
			ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					ex.getMessage();
					ex.printStackTrace();

				}
			}

		}
	}
}
