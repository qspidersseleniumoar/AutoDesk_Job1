package com.autodesk.crm.objectrepository.organizations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;

/**
 * 
 * @author adikiprakash
 *
 */
public class CreatingNewOrganizationPage implements IFilePaths{

	private WebDriver driver;
	private CommonLibrary common;
	
	@FindBy(name = "accountname") private WebElement orgNameEdtBx;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	@FindBy(name = "bill_street") private WebElement billAddEdtBx;
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']") private WebElement copyBillAddBtn;
	@FindBy(name = "ship_street") private WebElement shipAddEdtBx;
	@FindBy(xpath = "//input[@onclick='return copyAddressLeft(EditView)']") private WebElement shipBillAddBtn;
	
	/**
	 * @author adikiprakash
	 * Initialize Create New Organization Page
	 * @param driver
	 */
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	
	/**
	 * @author adikiprakash
	 * Used to create one organization with name
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @throws Throwable
	 */
	public void createOrgWithName(String sheetName, int rowNum, int celNum) throws Throwable {
		ExcelLib.openSheet(ORG, sheetName);
		String data = ExcelLib.getData(rowNum, celNum);
		orgNameEdtBx.sendKeys(data);
		saveBtn.click();
		ExcelLib.closeBook();
	}
	
	
	/**
	 * @author adikiprakash
	 * Enter data in Billing address edit box and click on Copy Billing Address
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String which supposed to enter in Billing address edit box
	 * @throws Throwable
	 */
	public String copyBillAdToShipAd(String sheetName, int rowNum, int colNum) throws Throwable {
		ExcelLib.openSheet(ORG, sheetName);
		String data = ExcelLib.getData(rowNum, colNum);
		ExcelLib.closeBook();
		billAddEdtBx.sendKeys(data);
		copyBillAddBtn.click();
		return data;
	}
	
	/**
	 * @author adikiprakash
	 * Fetch the value in Shipping address edit box
	 * @return
	 */
	public String shipAdreesInfo() {
		String attributeValue = shipAddEdtBx.getAttribute("value");
		return attributeValue;
		
	}
	
	
	/**
	 * @author adikiprakash
	 * Enter data in Shipping address edit box and click on Copy Shipping Address
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String which supposed to enter in Shipping address edit box
	 * @throws Throwable
	 */
	public String copyShipAdToBillAd(String sheetName, int rowNum, int colNum) throws Throwable {
		ExcelLib.openSheet(ORG, sheetName);
		String data = ExcelLib.getData(rowNum, colNum);
		ExcelLib.closeBook();
		shipAddEdtBx.sendKeys(data);
		shipBillAddBtn.click();
		return data;
	}
	
	
	/**
	 * @author adikiprakash
	 * Fetch the value in Billing address edit box
	 * @return
	 */
	public String billAdreesInfo() {
		String attributeValue = billAddEdtBx.getAttribute("value");
		return attributeValue;
		
	}
}
