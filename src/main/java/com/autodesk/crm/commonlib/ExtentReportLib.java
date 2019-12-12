package com.autodesk.crm.commonlib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportLib extends BaseClass{
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentTest logger;
	
	/**
	 * Allows to initialize the extent reports
	 */
	public static void extentInit() {
		/*intializes Extent HTML report*/
		extent = new ExtentReports("./test-output/ExtentReport.html", true);
		extent.addSystemInfo("Au8tomationLab", "SoftwareTestingMaterial").addSystemInfo("Environment", "Window")
				.addSystemInfo("User Name", "Deepak");
		/* load the extent config file */
		extent.loadConfig(new File("./extent-config.xml"));
	}
}
