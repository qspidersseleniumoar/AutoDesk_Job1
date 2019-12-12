package com.autodesk.crm.commonlib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
/**
 * 
 * @author Deepak
 *
 */
public class ExtentReportLib extends BaseClass{
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentTest logger;
	
	/**
	 * Initializes the extent report
	 */
	public static void extentInit() {
		/*intializes Extent HTML report*/
		extent = new ExtentReports(EXTENTREPORT, true);
		extent.addSystemInfo("AutomationLab", "SoftwareTestingMaterial").addSystemInfo("Environment", "Windows")
				.addSystemInfo("User Name", "Deepak").addSystemInfo("Build", "V 1.1");
		/* load the extent config file */
		extent.loadConfig(new File(EXTENTCONFIG));
	}
}
