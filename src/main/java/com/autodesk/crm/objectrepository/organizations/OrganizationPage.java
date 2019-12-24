package com.autodesk.crm.objectrepository.organizations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;

public class OrganizationPage implements IFilePaths {

//	public WebDriver getDriver()
//	{
//		return driver;
//	}

	private WebDriver driver;
	private CommonLibrary common;
	
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrganizationPlusLnk;
	@FindBy(xpath = "//input[@name='submit']") private WebElement searchNowBtn;
	@FindBy(xpath = "//a[text()='Create Filter']") private WebElement createFilterLnk;
	@FindBy(xpath = "//a[text()='Go to Advanced Search']") private WebElement advancedSearchLnk;
	@FindBy(xpath = "//img[@title='Import Organizations']") private WebElement importOrgImg;
	@FindBy(xpath = "//img[@title='Export Organizations']") private WebElement exportOrgImg;
	@FindBy(xpath = "//img[@title='Find Duplicates']") private WebElement findDuplicatesImg;
	@FindBy(xpath = "//img[@title='Organizations Settings']") private WebElement orgSettingsImg;
	@FindBy(xpath = "search_text") private WebElement searchEdt;
	@FindBy(xpath = "(//input[@value='Delete'])[1]") private WebElement delHeadBtn;;
	@FindBy(xpath = "//span[@vtfieldname='accountname']/preceding-sibling::a") private WebElement orgsLst;
	@FindBy(xpath = "//a[text()='del']") private WebElement delLnk;
	@FindBy(name = "selected_id") private WebElement selOneOrgChkBx;
	@FindBy(id = "selectCurrentPageRec") private WebElement selAllChkBx;
	
	public WebElement getOrgsLst() {
		return orgsLst;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getOrgSettingsImg() {
		return orgSettingsImg;
	}
	public WebElement getFindDuplicatesImg() {
		return findDuplicatesImg;
	}
	public WebElement getExportOrgImg() {
		return exportOrgImg;
	}
	public WebElement getImportOrgImg() {
		return importOrgImg;
	}
		
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public WebElement getCreateFilterLnk() {
		return createFilterLnk;
	}
	public WebElement getAdvancedSearchLnk() {
		return advancedSearchLnk;
	}
	
	
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
		createOrganizationPlusLnk.click();
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
