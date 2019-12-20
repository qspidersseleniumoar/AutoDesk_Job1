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
public class OrganizationPage implements IFilePaths{

	private WebDriver driver;
	private CommonLibrary common;
	
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createNewOrgImg;
	@FindBy(xpath = "//a[text()='del']") private WebElement delLnk;
	@FindBy(name = "selected_id") private WebElement selOneOrgChkBx;
	@FindBy(xpath = "(//input[@value='Delete'])[1]") private WebElement delHeadBtn;
	@FindBy(id = "selectCurrentPageRec") private WebElement selAllChkBx;
	
	/**
	 * @author adikiprakash
	 * Initialize Organizations Page
	 * @param driver
	 */
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	
	/**
	 * @author adikiprakash
	 * Navigate to create Organizations Page
	 * @param driver
	 */
	public CreatingNewOrganizationPage navigateToCreatingNewOrganization(){ 
		createNewOrgImg.click();
		common.waitForPageToLoad();
		return new CreatingNewOrganizationPage(driver);
	}
	
	/**
	 * @author adikiprakash
	 * click on delete link and cancel the Alert
	 * @return String Alert Message
	 */
	public String cancelDeleteOne() {
		delLnk.click();
		return common.dismissAlert();
	}
	
	
	/**
	 * @author adikiprakash
	 * Fetch data from excel based on sheetname, row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String data
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable {
		ExcelLib.openSheet(ORG, sheetName);
		String data = ExcelLib.getData(rowNum, colNum);
		ExcelLib.closeBook();
		return data;
	}
	
	
	/**
	 * @author adikiprakash
	 * select one organization check box, click on delete Head button and cancel the Alert
	 * @return String Alert Message
	 */
	public String cancelDelOneOrgFrmHeader() {
		selOneOrgChkBx.click();
		delHeadBtn.click();
		return common.dismissAlert();
	}
	
	
	/**
	 * @author adikiprakash
	 * click on delete link and accept the Alert
	 * @return String Alert Message
	 */
	public String acceptDeleteOne() {
		delLnk.click();
		return common.acceptAlert();
	}
	
	
	/**
	 * @author adikiprakash
	 * select one organization check box, click on delete Head button and accept the Alert
	 * @return String Alert Message
	 */
	public String acceptDelOneOrgFrmHeader() {
		selOneOrgChkBx.click();
		delHeadBtn.click();
		String alertMsg = common.acceptAlert();
		return alertMsg;
	}
	
	
	/**
	 * @author adikiprakash
	 * Select all organization check box, click on delete head button and cancel the Alert
	 * @return String Alert Message
	 */
	public String dismissMassDel() {
		selAllChkBx.click();
		delHeadBtn.click();
		String alertMsg = common.dismissAlert();
		return alertMsg;
	}
	
	
	/**
	 * @author adikiprakash
	 * Select all organization check box, click on delete head button and accept the Alert
	 * @return String Alert Message
	 */
	public String acceptMassDel() {
		selAllChkBx.click();
		delHeadBtn.click();
		String alertMsg = common.acceptAlert();
		return alertMsg;
	}
	
	
	/**
	 * @author adikiprakash
	 * click on delete head button
	 * @return
	 */
	public String deleteHead() {
		delHeadBtn.click();
		String alertMsg = common.acceptAlert();
		return alertMsg;
	}
}
