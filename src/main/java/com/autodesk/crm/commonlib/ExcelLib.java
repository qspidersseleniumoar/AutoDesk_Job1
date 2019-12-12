package com.autodesk.crm.commonlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author deepak
 *
 */
public class ExcelLib {

	private static Workbook workbook;
	private static Sheet sheet;
	private static String path;
	private static Properties prop;

	/**
	 * Open and load a sheet from workbook
	 * @param filePath
	 * @param sheetName
	 * @return Sheet specified
	 * @throws Throwable
	 */
	public static Sheet openSheet(String filePath, String sheetName) throws Throwable {
		path = filePath;
		workbook = WorkbookFactory.create(new FileInputStream(filePath));
		sheet = workbook.getSheet(sheetName);
		return sheet; 
	}

	/**
	 * Get data from the cell
	 * @param rowNum
	 * @param colNum
	 * @return String with cell data
	 * @throws Throwable
	 */
	public static String getData(int rowNum, int colNum) throws Throwable {
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		return data;
	}
	
	/**
	 * Close the workbook
	 * @throws Throwable
	 */
	public void closeSheet() throws Throwable {
		workbook.close();
	}

	/**
	 * Set a value in a cell
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public void setData(int rowNum, int colNum, String data) throws Throwable {
		Row row = sheet.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		workbook.write(new FileOutputStream(path));
	}

	/**
	 * Get the number of rows in the sheet
	 * @param filePath
	 * @param sheetName
	 * @return 
	 * @throws Throwable
	 */
	public int getRowCount(String filePath, String sheetName) throws Throwable {
		openSheet(filePath, sheetName);
		return sheet.getLastRowNum(); 
	}

	/**
	 * Open and load properties file
	 * @param filePath
	 * @return Properties file loaded
	 * @throws Throwable
	 */
	public Properties openProp(String filePath) throws Throwable {
		prop = new Properties();
		prop.load(new FileInputStream(filePath));
		return prop;
	}

	/**
	 * Get a property value
	 * @param key
	 * @return String with the key's value
	 */
	public String getValue(String key) {
		return prop.getProperty(key);
	}
}
