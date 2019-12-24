package com.autodesk.crm.objectrepository.contacts;

import java.util.Iterator;
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
	@FindBy(xpath="//img[@title='Find Duplicates']")
	private WebElement duplicateImg;
	@FindBy(xpath="//table[@class='searchUIBasic small']/tbody/tr[4]/td[1]/*")
	private WebElement dupSearchAvailFeilds;
	@FindBy(xpath="//input[@class='crmButton small'][1]")
	private WebElement moveSelectedFieldBtn;
	@FindBy(name="save&merge")
	private WebElement findDuplicatesBtn;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[1]/*")
	private List<WebElement> duplicateCheckBxs;
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement duplicateDeleteBtn;
	@FindBy(xpath="(//table[@class='lvt small']/tbody/tr[*]/td[5]/*)[1]")
	private WebElement dupliMergeChkBx;
	@FindBy(xpath="(//table[@class='lvt small']/tbody/tr[*]/td[6]/*)[1]")
	private WebElement dupliMergeBtn;
	@FindBy(xpath="//table[@class='tableHeading']/tbody/tr[1]/td/*")
	private WebElement DupliContactPgHeader;
	@FindBy (id="email")
	private WebElement emailEdtBx;
	@FindBy (id="title")
	private WebElement titleEdtBx;
	@FindBy (id="phone")
	private WebElement phnNoEdtBx;
	@FindBy (xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]")
	private List<WebElement> lastNameClmn;
	@FindBy (xpath="//table[@class='lvt small']/tbody/tr[*]/td[5]")
	private List<WebElement> mergeChkBxClmn;
	

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
		lastNameTB.sendKeys(ExcelLib.getData(1,3));
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
	
	/**
	 * @author Ramakanth
	 * @param SheetName
	 * @param rowNum
	 * @param ColumnNum
	 * @throws Throwable
	 * used to create contact using only lastname
	 */
	public void createOnlyLastname(String SheetName,int rowNum, int ColumnNum) throws Throwable {
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,SheetName);
		lastNameTB.sendKeys(ExcelLib.getData(rowNum,ColumnNum));
		saveButton.click();		
	}
	
	/**
	 * @author Ramakanth
	 * @param SheetName
	 * @param rowNum
	 * @param ColumnNum
	 * @param emailCelNum
	 * @throws Throwable
	 * used to create a contact using last name and email 
	 */
	public void createLastname_email(String SheetName,int rowNum, int ColumnNum, int emailCelNum) throws Throwable {
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,SheetName);
		lastNameTB.sendKeys(ExcelLib.getData(rowNum,ColumnNum));
		emailEdtBx.sendKeys(ExcelLib.getData(rowNum, emailCelNum));
		saveButton.click();		
	}
	
	/**
	 * @author Ramakanth
	 * @param SheetName
	 * @param rowNum
	 * @param ColumnNum
	 * @param PhnCelNum
	 * @throws Throwable
	 * used to create a contact using last name and phone number
	 */
	public void createLastname_PhnNo(String SheetName,int rowNum, int ColumnNum, int PhnCelNum) throws Throwable {
		createContactPlusBtn.click();
		commonlib.waitForPageToLoad();
		ExcelLib.openSheet(CNT,SheetName);
		lastNameTB.sendKeys(ExcelLib.getData(rowNum,ColumnNum));
		emailEdtBx.sendKeys(ExcelLib.getData(rowNum, PhnCelNum));
		saveButton.click();		
	}
	
	
	/**
	 * @author Ramakanth
	 * @throws Throwable 
	 * used to click on contacts tab
	 */
	public void navigateToContacts() throws Throwable{
		commonlib.waitAndClick(contactsTab);
	}
	
	/**
	 * @author Ramakanth
	 * @param criteria
	 * used to click on duplicates image and search for duplicates using search criteria
	 */
	public void findDuplicates(String criteria) {
		duplicateImg.click();
		commonlib.waitForPageToLoad();
		CommonLibrary clib=new CommonLibrary(driver);
		clib.selectOption(dupSearchAvailFeilds, criteria);
		moveSelectedFieldBtn.click();
		findDuplicatesBtn.click();
	}
	
	/**
	 * @author Ramakanth
	 * used to click on the check box of duplicated contacts
	 */
	public void selectDupliChkBx() {
		int size = duplicateCheckBxs.size();
		//System.out.println(size);
		Iterator<WebElement> it = duplicateCheckBxs.iterator();
		
			it.next().click();
			it.next().click();	
	}
	
	/**
	 * @author Ramakanth
	 * @return alert message
	 * used to click on delete button and click on ok
	 */
	public String deleteDulicate() {
		duplicateDeleteBtn.click();
		return commonlib.acceptAlert();
	}
	
	/**
	 * @author Ramakanth
	 * @return alert message 
	 * used to click on delete button and click on cancel
	 */
	public String deleteDulicateCancel() {
		duplicateDeleteBtn.click();
		return commonlib.dismissAlert();
	}
	
	/**
	 * @author Ramakanth
	 * @param alrtMsg
	 * @return int
	 * used to fetch number present in the string
	 */
	public String delDupCount(String alrtMsg) {
		String[] s1=alrtMsg.split(" ");
		return s1[9];	
	}
	
	/**
	 * @author Ramakanth
	 * click on merge button
	 */
	public void selectDuplicateMergeChkBx() {
		dupliMergeChkBx.click();
	}
	
	/**
	 * @author Ramakanth
	 * @return alrtMsg
	 * used click on merge button and click on ok
	 */
	public String clickDupliMergeBtn() {
		dupliMergeBtn.click();
		return commonlib.acceptAlert();
	}
	
	/**
	 * @author Ramakanth
	 * @return String
	 * used to get the header of the duplicate contact page
	 */
	public String duplicateContactPage() {
		return DupliContactPgHeader.getText();
	}
	
	/**
	 * @author Ramakanth
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String
	 * @throws Throwable
	 * used to open the workbook, Sheet and fetch data from excel sheet 
	 */
	public String getData(String sheetName, int rowNum, int colNum) throws Throwable {
		ExcelLib.openSheet(CNT, sheetName);
		String data=ExcelLib.getData(rowNum, colNum);
	    ExcelLib.closeBook();
	    return data;
	}
	
}
