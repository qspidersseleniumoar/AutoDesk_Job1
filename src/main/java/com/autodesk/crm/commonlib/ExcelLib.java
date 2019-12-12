package com.autodesk.crm.commonlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sun.media.sound.InvalidFormatException;

/**
 * 
 * @author deepak
 *
 */
@SuppressWarnings("restriction")
public class ExcelLib {

	/**
	 * used to read data from Excel
	 * 
	 * @param filePath
	 * @param sheetNAme
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws EncryptedDocumentException
	 */
	
	public String getExcelData(String filePath, String sheetNAme, int rowNum, int colNum)
			throws EncryptedDocumentException, InvalidFormatException, IOException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNAme);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}

	/**
	 * Write data back to Excel
	 * 
	 * @param sheetNAme
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 */
	public void setExcelData(String filePath, String sheetNAme, int rowNum, int colNum, String data)
			throws EncryptedDocumentException, InvalidFormatException, IOException,
			org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNAme);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();

	}

	/**
	 * get the TestData.Excel last used Row Count
	 * 
	 * @param sheetNAme
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws                            org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 */
	public int getRowCount(String filePath, String sheetNAme) throws EncryptedDocumentException, InvalidFormatException,
			IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetNAme);
		int rowIndex = sh.getLastRowNum();
		return rowIndex;

	}

	/**
	 * load property files
	 * 
	 * @return
	 * @throws Throwable
	 */
	public Properties loadPropertyFile(String filePath) throws Throwable {
		FileInputStream fis = new FileInputStream(filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		return pObj;
	}

	/**
	 * get the value for the specified key from the property file
	 * 
	 * @param pObj
	 * @param key
	 * @return
	 */
	public String getValueFromPropertyFile(Properties pObj, String key) {
		return pObj.getProperty(key);
	}
}
