package com.autodesk.crm.objectrepository.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;
import com.autodesk.crm.objectrepository.leads.LeadsPage;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;

/**
 * 
 * @author Deepak
 *
 */
public class HomePage{
	
	private WebDriver driver;
	private Actions act;
	private CommonLibrary common;

	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']") private WebElement homeLogo;
	@FindBy(linkText="Calendar") private WebElement calendarTab;
	@FindBy(linkText="Leads") private WebElement leadsTab;               	 		 		 	 		 		 		
	@FindBy(linkText="Contacts") private WebElement contactsTab;
	@FindBy(linkText="Opportunities") private WebElement oppportunitiesTab;
	@FindBy(linkText="Products") private WebElement productsTab;
	@FindBy(linkText="Organizations") private WebElement organizationsTab;
	@FindBy(linkText="Email") private WebElement emailTab;
	@FindBy(linkText="Trouble Tickets") private WebElement troubleTicketsTab;
	@FindBy(linkText="Dashboard") private WebElement dashboardTab;
	@FindBy(linkText="More") private WebElement moreTab;
	@FindBy(xpath="//img[@title='Chat...']") private WebElement chatIcon;
	@FindBy(linkText="Campaigns") private WebElement campaignsTab;
	@FindBy(linkText="Reports") private WebElement reportsTab;
	@FindBy(linkText="SMSNotifier") private WebElement smsNotifierTab;
	@FindBy(linkText="Comments") private WebElement commentsTab;
	@FindBy(linkText="Quotes") private WebElement quotesTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement adminLogo;
	@FindBy(linkText="Sign Out") private WebElement signoutLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']") private WebElement infoLnk;
	@FindBy(linkText="My_Preferences") private WebElement myPreferencesTab;
	@FindBy(linkText="Help") private WebElement helpTab;
	@FindBy(linkText="CRM Settings") private WebElement crmSettingsTab;
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']") private WebElement settingsImg;

	/**
	 * Initiate the home page
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
		common = new CommonLibrary(driver);
	}

	/**
	 * Navigate to Home
	 */
	public void navigateTohome(){
		homeLogo.click();
	}

	/**
	 * Navigate to Calendar
	 */
	public void navigateToCalendar(){  
		calendarTab.click();
	}

	/**
	 * Navigate to Leads
	 * @return 
	 */
	public LeadsPage navigateToLeads(){
		leadsTab.click();
		common.waitForPageToLoad();
		return new LeadsPage(driver);
	}

	/**
	 * Navigate to Organizations
	 */
	public void navigateToOrganizations(){ 
		organizationsTab.click();
	}

	/**
	 * Navigate to Contacts
	 * @return 
	 */
	public ContactsPage navigateToContacts(){
		contactsTab.click();
		return new ContactsPage(driver);
	}

	/**
	 * @author Tess
	 * Navigate to Opportunities
	 * @return 
	 */
	public OpportunitiesPage navigateToOpportunities(){
		
		oppportunitiesTab.click();
		common.waitForPageToLoad();
		return new OpportunitiesPage(driver);
	}

	/**
	 * Navigate to Products
	 */
	public void navigateToProducts(){
		productsTab.click();
	}

	/**
	 * Navigate to Email
	 */
	public void navigateToEmail(){
		emailTab.click();
	}

	/**
	 * Navigate to Dashboard
	 */
	public void navigateToDashboard(){
		dashboardTab.click();
	}

	/**
	 * Navigate to More
	 */
	public void navigateToMore(){
		act.moveToElement(moreTab).perform();;
	}

	/**
	 * Navigate to Reports
	 */
	public void navigateToReports(){
		reportsTab.click();
	}

	/**
	 * Navigate to SMSNotifier
	 */
	public void navigateToSMSNotifier(){
		smsNotifierTab.click();
	}

	/**
	 * Navigate to Comments
	 */
	public void navigateToComments(){
		commentsTab.click();
	}

	/**
	 * Navigate to Quotes
	 */
	public void navigateToQuotes(){
		quotesTab.click();
	}

	/**
	 * Signout of the application
	 */
	public void signOut(){
		act.moveToElement(adminLogo).perform(); 
		signoutLnk.click();
	}
	
	/**
	 * Open preferences
	 */
	public void My_Preferences(){
		act.moveToElement(adminLogo).perform();
		myPreferencesTab.click();
	}

	/**
	 * Opens Help
	 */
	public void Help(){
		act.moveToElement(infoLnk);
		helpTab.click();
	}
	
	/**
	 * Opens Settings
	 */
	public void CRM_Settings(){
		act.moveToElement(settingsImg);
		crmSettingsTab.click();
	}
}
