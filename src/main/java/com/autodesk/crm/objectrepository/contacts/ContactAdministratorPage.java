package com.autodesk.crm.objectrepository.contacts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.autodesk.crm.commonlib.CommonLibrary;

public class ContactAdministratorPage {
	private WebDriver driver;
	private Actions act;
	CommonLibrary commonlib=new CommonLibrary(driver);
	@FindBy(name="search_text")private WebElement searchFor;
	@FindBy(xpath="(//select[@id='bas_searchfield'])[1]")private WebElement searchDropdwon;
	@FindBy(xpath="//input[@value=' Search Now ' and@name='submit']")private WebElement searchNow;
	@FindBy(xpath="//table[@class='lvt small']")private WebElement contactTable;
	@FindBy(xpath="//table[@class='lvt small']//tr[3]")private WebElement numberOfrows;
	@FindBy(xpath="//table[@class='lvt small']//tr[3]//td")private List<WebElement> numberOfcolumns;
	@FindBy(linkText="Contacts") private WebElement contactsTab;
	
	public ContactAdministratorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		this.driver = driver;
//		act = new Actions(driver);
	}
	
	public WebElement getSearchFor() {
		return searchFor;
	}
	public WebElement getSearchDropdwon() {
		return searchDropdwon;
	}
	public WebElement getSearchNow() {
		return searchNow;
	}
	public WebElement getContactTable() {
		return contactTable;
	}
	
	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getNumberOfrows() {
		return numberOfrows;
		
	}
//	public void numberRows()
//	{
//		 int rows=numberOfrows.size();
//		 Reporter.log("number of rows"+ rows, true);
//		
//	}
	public void numbercolumns()
	{
		 int columns=numberOfcolumns.size();
		 Reporter.log("number of columns"+" "+ columns, true);
		
	}
	public  void  selectCoustomer(String contactid)
	{

	
		for(int j=1;j<=numberOfcolumns.size();j++)
		{
			 String contact=numberOfcolumns.get(j).getText();
			
   if(contact.equalsIgnoreCase(contactid))
  {
	   
	   Reporter.log(contact,true);
	Reporter.log("contactisdisplayed",true);
	break;
			}			
   }
			 
		}
	public void waitafterClick() throws Throwable
	{
		commonlib.waitAndClick(contactsTab);
	}
	
	public void searchContact(String contactid,int index)
	{
		searchFor.sendKeys(contactid);
	commonlib.selectOption(searchDropdwon,index);
	searchNow.click();
	}
}
	
 

