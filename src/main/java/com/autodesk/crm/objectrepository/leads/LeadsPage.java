package com.autodesk.crm.objectrepository.leads;

import static com.autodesk.crm.commonlib.ExcelLib.closeBook;
import static com.autodesk.crm.commonlib.ExcelLib.getData;
import static com.autodesk.crm.commonlib.ExcelLib.openSheet;
import static com.autodesk.crm.commonlib.ExcelLib.setData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.IFilePaths;

/**
 * 
 * @author Ramya
 *
 */
public class LeadsPage implements IFilePaths{
	
	private WebDriver driver;
	private CommonLibrary common;
	
	@FindBy(xpath="//img[contains(@src,'btnL3Add.gif')]") private WebElement plusBtn;
	@FindBy(xpath="//input[contains(@title,'Cancel')]") private WebElement cancelBtn;
	@FindBy(name="firstname") private WebElement firstnameTxtB;
	@FindBy(name="lastname") private WebElement lastnameTxtB;
	@FindBy(name="company") private WebElement companyTxtB;
	@FindBy(xpath="//input[@type='submit']") private WebElement saveBtn;
	@FindBy(xpath="//tr[contains(@id, 'row_')]/descendant::a") private WebElement tableRow;
	@FindBy(id="mouseArea_First Name") private WebElement firstName;
	@FindBy(id="mouseArea_Last Name") private WebElement lastName;
	@FindBy(id="dtlview_Company") private WebElement companyName;
	@FindBy(xpath="//input[@name='selectall']") private WebElement selectAllChkbx;
	@FindBy(xpath="//input[@value='Delete']") private WebElement deleteBtn;
	
	
	/**
	 * Initiate the leads page
	 * @param driver
	 */
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	/**
	 * Create a lead using the plus button by reading data from an excel sheet one record at a time
	 */
	public void createUsingPlus() throws Throwable {
		plusBtn.click();
		openSheet(LDS, "Create");
		firstnameTxtB.sendKeys(getData(1, 0));
		lastnameTxtB.sendKeys(getData(1, 1));
		companyTxtB.sendKeys(getData(1, 2));
		closeBook();
		saveBtn.click();
	}
	
	/**
	 * Create bulk leads using the plus using reading data in the formal arguments
	 * All the data is loaded at once using a dataprovider
	 * The dataprovider then sends the data to the formal arguments
	 * Dataprovider calls the method once for each row
	 */
	public void createBulkUsingPlus(String firstname, String lastname, String company) throws Throwable {
		plusBtn.click();
		common.waitForPageToLoad();
		firstnameTxtB.sendKeys(firstname);
		lastnameTxtB.sendKeys(lastname);
		companyTxtB.sendKeys(company);
		saveBtn.click();
	}
	
	/**
	 * Feed the data from the application into excel sheets
	 */
	public void feedInfo() throws Throwable {
		tableRow.click();
//		waitForPageToLoad();
		openSheet(LDS, "Export");
		setData(2, 0, firstName.getText());
		setData(2, 1, lastName.getText());
		setData(2, 2, companyName.getText());
		closeBook();
	}
	
	/**
	 * Selects all the records on the page and deletes them at once
	 */
	public void deleteMultiple() {
		selectAllChkbx.click();
		deleteBtn.click();
		common.acceptAlert();
	}
}
