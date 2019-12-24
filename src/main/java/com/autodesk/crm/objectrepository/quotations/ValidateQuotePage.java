package com.autodesk.crm.objectrepository.quotations;

import static com.autodesk.crm.commonlib.ExcelLib.openSheet;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;

/**
 * 
 * @author Vinita
 *
 */

public class ValidateQuotePage implements IFilePaths {

	private WebDriver driver;
	private CommonLibrary commonLib;

	@FindBy(id = "fcol0")
	private WebElement dropDown1;
	@FindBy(id = "fop0")
	private WebElement dropDown2;
	@FindBy(id = "fval0")
	private WebElement searchDataTB;
	@FindBy(xpath = "(//input[@class='crmbutton small create'])[2]")
	private WebElement searchBtn;
	/**
	 * @author Vinita
	 */
	@FindBy(linkText = "quote10")
	private WebElement q10Sub;
	@FindBy(linkText = "quote11")
	private WebElement q11Sub;
	@FindBy(linkText = "quote12")
	private WebElement q12Sub;
	@FindBy(linkText = "quote13")
	private WebElement q13Sub;
	@FindBy(xpath = "(//td[contains(text(),'Created')] )")
	private WebElement created;
	@FindBy(xpath = "(//td[contains(text(),'Delivered')] )")
	private WebElement delivered;
	@FindBy(xpath = "(//td[contains(text(),'Reviewed')] )")
	private WebElement reviewed;

	public ValidateQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		commonLib = new CommonLibrary(driver);
	}

	public void verifySubOpputurnityName() throws Throwable {

		openSheet(QTN, "Sheet1");
		Assert.assertEquals(q10Sub.getText(),ExcelLib.getData(1,0));
		Reporter.log("Verified", true);
	}
	
	public void verifySubQuoteStage1() throws Throwable {
		
		openSheet(QTN, "Sheet1");
		Assert.assertEquals(q11Sub.getText(),ExcelLib.getData(2,0));
		Reporter.log("Verified", true);
		Assert.assertEquals(created.getText(),ExcelLib.getData(1,1));
		Reporter.log("Verified", true);
	}
	
	public void verifySubQuoteStage2() throws Throwable {
		
		openSheet(QTN, "Sheet1");
		Assert.assertEquals(q12Sub.getText(),ExcelLib.getData(3,0));
		Reporter.log("Verified", true);
		Assert.assertEquals(delivered.getText(),ExcelLib.getData(2,1));
		Reporter.log("Verified", true);
	}
	public void verifySubQuoteStage3() throws Throwable {
		
		openSheet(QTN, "Sheet1");
		Assert.assertEquals(q13Sub.getText(),ExcelLib.getData(4,0));
		Reporter.log("Verified", true);
		Assert.assertEquals(reviewed.getText(),ExcelLib.getData(3,1));
		Reporter.log("Verified", true);
	}
}
