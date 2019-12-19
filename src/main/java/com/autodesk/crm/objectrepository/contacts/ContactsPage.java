package com.autodesk.crm.objectrepository.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;

public class ContactsPage implements IFilePaths{

	private WebDriver driver;


	private CommonLibrary commonlib ;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactPlusBtn;
	@FindBy(name = "salutationtype")
	private WebElement titleDdown;
	@FindBy(name = "firstname")
	private WebElement firstnameTB;
	@FindBy(name = "lastname")
	private WebElement lastNameTB;
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement organizationName;
	@FindBy(name = "leadsource")
	private WebElement leadDropdown;
	@FindBy(id = "title")
	private WebElement title;
	@FindBy(xpath = "(//input[@name='button' ])[1]")
	private WebElement saveButton;
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	@FindBy(id = "qccombo")
	private WebElement quickCreate;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		commonlib = new CommonLibrary(driver);
	}
	public void createContact() throws Throwable

	{
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,"Sheet1");
		firstnameTB.sendKeys(ExcelLib.getData(1,0));
		lastNameTB.sendKeys(ExcelLib.getData(1,1));
		commonlib.selectOption(leadDropdown, 2);
		title.sendKeys(ExcelLib.getData(1,3));
		saveButton.click();
		// return new ContactAdministratorPage(driver);

	}
	/**
	 * 
	 * @author Gowri
	 */
	public void createOnlyLastname() throws Throwable
	{
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,"Sheet1");
		lastNameTB.sendKeys(ExcelLib.getData(3,1));
		saveButton.click();
	}

	public void createOnlyFirstName() throws Throwable
	{
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,"Sheet1");
		firstnameTB.sendKeys(ExcelLib.getData(4,0));
		saveButton.click();
	}

}
