package com.autodesk.crm.commonlib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author Deepak
 *
 */
public class Listener extends ExtentReportLib implements ITestListener {

	public static String testCaseName;
	
	
	public void onTestFailure(ITestResult result) {
		logger.log(LogStatus.FAIL, "Failed "+result.getName());
		EventFiringWebDriver edr = new EventFiringWebDriver(driver);
		File srcFile = edr.getScreenshotAs(OutputType.FILE);
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		File dfile = new File("./screenshot_"+date +"/"+ testCaseName + ".png");
		try {
			FileUtils.copyFile(srcFile, dfile);
		} catch (IOException e) {
		}

	}

	public void onFinish(ITestContext result) {
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}

	public void onStart(ITestContext result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {
		logger.log(LogStatus.SKIP, "Skipped "+result.getName());
	}

	public void onTestStart(ITestResult result) {
		logger = extent.startTest(result.getName());
		logger.log(LogStatus.INFO, "Started "+result.getName());
		testCaseName = result.getTestClass().getName().toString();
		testCaseName = testCaseName.substring(testCaseName.lastIndexOf(".") + 1, testCaseName.length());

	}

	public void onTestSuccess(ITestResult result) {
		logger.log(LogStatus.PASS, "Passed "+result.getName());
	}

}
