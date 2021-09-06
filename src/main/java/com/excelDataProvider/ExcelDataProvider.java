package com.excelDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	

	static FileInputStream file;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static Object[][] obj;
	
	@DataProvider(name = "loginData")
	public static Object readXl() {
		try {
			file = new FileInputStream(new File("XL-data/loginData.xlsx"));
			book = new XSSFWorkbook(file);
			sheet = book.getSheetAt(0);
			// String v = sheet.getRow(1).getCell(0).getStringCellValue();
			int rowN = sheet.getLastRowNum();
			int cellN = sheet.getRow(0).getLastCellNum();
			obj = new Object[rowN][cellN];
			

			for (int i = 1; i < rowN; i++) {
				for (int j = 0; j < cellN; j++) {
					XSSFCell ce = sheet.getRow(i).getCell(j);

					switch (ce.getCellType()) {
					case XSSFCell.CELL_TYPE_NUMERIC: {
						System.out.println(ce.getNumericCellValue());
						obj[i-1][j] = ce.getNumericCellValue();
					}
					case XSSFCell.CELL_TYPE_STRING: {
						System.out.println(ce.getStringCellValue());
						obj[i-1][j] = ce.getStringCellValue();
					} 

					default:
						break;
					}
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj;
	}

}
