package com.autodesk.crm.commonlib;

/**
 * 
 * @author Deepak
 *
 */
public interface IFilePaths {
	
	String EXTENTCONFIG = "./extent-config.xml";
	String EXTENTREPORT = "./test-output/ExtentReport.html";

//	-------------------------Common Paths-------------------------
	String PROP = "./src/main/resources/properties/";
	String EXCEL = "./src/main/resources/excel/";
	String PHOTO = "./src/test/resources/photo/";
	String REPORTS = "./src/test/resources/reports/";
	
//	-------------------------Excel Files-------------------------
	String ORG = EXCEL+"organizations.xlsx";
	String CNT = EXCEL+"contacts.xlsx";
	String OPP = EXCEL+"opportunities.xlsx";
	String QTN = EXCEL+"quotations.xlsx";
	String LDS = EXCEL+"leads.xlsx";
	
//	-------------------------Properties Files-------------------------
//	String SMP = PROP+"sample.properties";
}
