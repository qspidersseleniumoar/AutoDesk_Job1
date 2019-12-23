package com.autodesk.crm.objectrepository.organizations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.IFilePaths;

public class OrganizationPage implements IFilePaths {

//	public WebDriver getDriver()
//	{
//		return driver;
//	}

	private WebDriver driver;
	
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrganizationPlusLnk;
	@FindBy(xpath = "//input[@name='submit']") private WebElement searchNowBtn;
	@FindBy(xpath = "//a[text()='Create Filter']") private WebElement createFilterLnk;
	@FindBy(xpath = "//a[text()='Go to Advanced Search']") private WebElement advancedSearchLnk;
	@FindBy(xpath = "//img[@title='Import Organizations']") private WebElement importOrgImg;
	@FindBy(xpath = "//img[@title='Export Organizations']") private WebElement exportOrgImg;
	@FindBy(xpath = "//img[@title='Find Duplicates']") private WebElement findDuplicatesImg;
	@FindBy(xpath = "//img[@title='Organizations Settings']") private WebElement orgSettingsImg;
	@FindBy(xpath = "search_text") private WebElement searchEdt;
	@FindBy(xpath = "(//input[@value='Delete'])[1]") private WebElement deleteBtn;
	@FindBy(xpath = "//span[@vtfieldname='accountname']/preceding-sibling::a") private WebElement orgsLst;
	
	public WebElement getOrgsLst() {
		return orgsLst;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
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
	 * Initiate Organization Page
	 * @param driver
	 */
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/**
	 * Navigate to CreatingNewOrganizationPage 
	 * @return
	 */
	public CreatingNewOrganizationPage navigateToCreatingNewganization() {
		createOrganizationPlusLnk.click();
		return new CreatingNewOrganizationPage(driver);
	}
	
	
}
