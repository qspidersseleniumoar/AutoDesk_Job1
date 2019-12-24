package com.autodesk.crm.objectrepository.contacts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;
import com.autodesk.crm.objectrepository.common.HomePage;

public class ContactsPage implements IFilePaths{

	private WebDriver driver;


	private CommonLibrary commonlib ;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement ContactsTab;
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
	@FindBy(xpath = "//input[@type='radio' and @value='U']")
	private WebElement radioButton;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement SelectInDropdown;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement EnterNameInSearchBox;
	@FindBy(xpath="//input[@name='submit' and @value=' Search Now ']")
	private WebElement ClickSearchNow;
	@FindBy(xpath="//a[contains(text(),'del')]")
	private WebElement DeleteContact;
	@FindBy(xpath="//input[@id='6']")
	private WebElement CheckBox;
	@FindBy(xpath="//*[@id=\"massdelete\"]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/input[1]")
	private WebElement HeaderDeleteButton;
	@FindBy(xpath="//a[.='vtiger']")
	private WebElement LoginPageImageText;
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement AdministratorDropDown;
	@FindBy(xpath="//td[@class='moduleName']/a[.='Contacts']")
	private WebElement ContactsPage;
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement NoContacts;
	

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
		 //return new ContactAdministratorPage(driver);

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
	
	/**
	 * 
	 * @author Navya
	 * 
	 */
	public void createContactWithUser() throws Throwable 
	{
		createContactPlusBtn.click();
		Thread.sleep(5000);
		radioButton.click();
		HomePage home=new HomePage(driver);
		home.signOut();
		String text = LoginPageImageText.getText();
		ExcelLib.openSheet(CNT,"Sheet1");
		Assert.assertEquals(text,ExcelLib.getData(1,3));
		Reporter.log("login page is displayed",true);
	}
	
	public void createContactWithAdministrator() throws Throwable 
	{
		createContactPlusBtn.click();
		radioButton.click();
		Thread.sleep(5000);
		Select sel=new Select(AdministratorDropDown);
		String text=sel.getFirstSelectedOption().getText();
		ExcelLib.openSheet(CNT,"Sheet1");
		Assert.assertEquals(text,ExcelLib.getData(1,4));
		Reporter.log("Administrator dropdown is selected",true);
		HomePage home=new HomePage(driver);
		home.signOut();
		String text1 = LoginPageImageText.getText();
		Assert.assertEquals(text1,ExcelLib.getData(1,3));
		Reporter.log("login page is displayed",true);
	}
	
	public void OpenContactAndDeleteContact() throws Throwable 
	{
		SelectInDropdown.click();
		Thread.sleep(5000);
		commonlib.selectOption(SelectInDropdown, 1);
		EnterNameInSearchBox.click();
		ExcelLib.openSheet(CNT,"Sheet1");
		EnterNameInSearchBox.sendKeys(ExcelLib.getData(1,1));
		ClickSearchNow.click();
		Thread.sleep(5000);
		DeleteContact.click();
		commonlib.acceptAlert();
		String text = ContactsPage.getText();
		Assert.assertEquals(text,"Contacts");
		Reporter.log("Contacts page is displayed",true);
		SelectInDropdown.click();
		Thread.sleep(5000);
		commonlib.selectOption(SelectInDropdown, 1);
		EnterNameInSearchBox.click();
		String text1 = NoContacts.getText();
		ExcelLib.openSheet(CNT,"Sheet1");
		Assert.assertEquals(text1, ExcelLib.getData(1,5));
		Reporter.log("Contact should not be displayed",true);
	}
	
	public void OpenContactAndDeleteThatContactAndCancel() throws Throwable 
	{
		SelectInDropdown.click();
		Thread.sleep(5000);
		commonlib.selectOption(SelectInDropdown, 1);
		EnterNameInSearchBox.click();
		ExcelLib.openSheet(CNT,"Sheet1");
		EnterNameInSearchBox.sendKeys(ExcelLib.getData(1,0));
		ClickSearchNow.click();
		String text = ContactsPage.getText();
		Assert.assertEquals(text,"Contacts");
		Reporter.log("Contacts page is displayed after searching for ContactName",true);
		Thread.sleep(5000);
		DeleteContact.click();
		commonlib.dismissAlert();
		String text1 = ContactsPage.getText();
		Assert.assertEquals(text1,"Contacts");
		Reporter.log("Contacts page is displayed after clicking on CancelButton",true);
	}
	
	public void SelectContactAndDeleteOneContactWithHeaderDelete() throws Throwable
	{
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,"Sheet1");		
		firstnameTB.sendKeys(ExcelLib.getData(1,0));		
		lastNameTB.sendKeys(ExcelLib.getData(1,1));	
		saveButton.click();	
		ContactsTab.click();	
		CheckBox.click();	
		HeaderDeleteButton.click();
		commonlib.acceptAlert();	
	}
	
	public void SelectContactAndDeleteOneContactWithHeaderDeleteAndCancel() throws Throwable
	{
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,"Sheet1");		
		firstnameTB.sendKeys(ExcelLib.getData(1,0));		
		saveButton.click();	
		String text = ContactsPage.getText();
		Assert.assertEquals(text,"Contacts");
		Reporter.log("Contacts page is displayed",true);
		ContactsTab.click();	
		CheckBox.click();	
		HeaderDeleteButton.click();
		commonlib.dismissAlert();	
		String text1 = ContactsPage.getText();
		Assert.assertEquals(text1,"Contacts");
		Reporter.log("Contacts page is displayed after clicking on CancelButton",true);

	}
	
	
}
