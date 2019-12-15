package com.autodesk.crm.commonlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
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
		if(row==null)
			row = sheet.createRow(rowNum);
		String data = row.getCell(colNum, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
		return data;
	}

	/**
	 * Set a value in a cell
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public static void setData(int rowNum, int colNum, String data) throws Throwable {
		Row row = sheet.getRow(rowNum);
		if(row==null)
			row = sheet.createRow(rowNum);
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
	public static int getRowCount(String filePath, String sheetName) throws Throwable {
		openSheet(filePath, sheetName);
		return sheet.getLastRowNum(); 
	}
	
	/**
	 * Close the workbook
	 * @throws Throwable
	 */
	public static void closeBook() throws Throwable {
		workbook.close();
	}

	/**
	 * Open and load properties file
	 * @param filePath
	 * @return Properties file loaded
	 * @throws Throwable
	 */
	public static Properties openProp(String filePath) throws Throwable {
		prop = new Properties();
		prop.load(new FileInputStream(filePath));
		return prop;
	}

	/**
	 * Get a property value
	 * @param key
	 * @return String with the key's value
	 */
	public static String getValue(String key) {
		return prop.getProperty(key);
	}
}
