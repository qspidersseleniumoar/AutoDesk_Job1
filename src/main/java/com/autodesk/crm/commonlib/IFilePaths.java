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
	String ORG = EXCEL+"organization.xlsx";
	String CNT = EXCEL+"contact.xlsx";
	String OPP = EXCEL+"opportunity.xlsx";
	String QTN = EXCEL+"quotation.xlsx";
	String LDS = EXCEL+"lead.xlsx";
	
//	-------------------------Properties Files-------------------------
//	String SMP = PROP+"sample.properties";
}
