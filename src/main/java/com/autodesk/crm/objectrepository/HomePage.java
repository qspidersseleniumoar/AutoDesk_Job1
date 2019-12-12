package com.autodesk.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepak
 *
 */
public class HomePage{
	
	private WebDriver driver;
	private Actions act;

	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']") private WebElement home;
	@FindBy(linkText="Calendar") private WebElement Calendar;
	@FindBy(linkText="Leads") private WebElement Leads;               	 		 		 	 		 		 		
	@FindBy(linkText="Contacts") private WebElement Contacts;
	@FindBy(linkText="Opportunities") private WebElement Opportunities;
	@FindBy(linkText="Products") private WebElement Products;
	@FindBy(linkText="Organizations") private WebElement Organizations;
	@FindBy(linkText="Email") private WebElement Email;
	@FindBy(linkText="Trouble Tickets") private WebElement Trouble_Tickets;
	@FindBy(linkText="Dashboard") private WebElement Dashboard;
	@FindBy(linkText="More") private WebElement More;
	@FindBy(xpath="//img[@title='Chat...']") private WebElement chat;
	@FindBy(linkText="Campaigns") private WebElement Campaigns;
	@FindBy(linkText="Reports") private WebElement Reports;
	@FindBy(linkText="SMSNotifier") private WebElement SMSNotifier;
	@FindBy(linkText="Comments") private WebElement Comments;
	@FindBy(linkText="Quotes") private WebElement Quotes;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement admin;
	@FindBy(linkText="Sign Out") private WebElement Sign_Out;
	@FindBy(xpath="//img[@src='themes/softed/images/info.PNG']") private WebElement info_img;
	@FindBy(linkText="My_Preferences") private WebElement My_Preferences;
	@FindBy(linkText="Help") private WebElement Help;
	@FindBy(linkText="CRM Settings") private WebElement CRM_Settings;
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']") private WebElement setting_img;

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
	}

	/**
	 * Navigate to Home
	 */
	public void navigateTohome(){
		home.click();
	}

	/**
	 * Navigate to Calendar
	 */
	public void navigateToCalendar(){  
		Calendar.click();
	}

	/**
	 * Navigate to Leads
	 */
	public void navigateToLeads(){
		Leads.click();
	}

	/**
	 * Navigate to Organizations
	 */
	public void navigateToOrganizations(){ 
		Organizations.click();
	}

	/**
	 * Navigate to Contacts
	 */
	public void navigateToContacts(){
		Contacts.click();
	}

	/**
	 * Navigate to Opportunities
	 */
	public void navigateToOpportunities(){
		Opportunities.click();
	}

	/**
	 * Navigate to Products
	 */
	public void navigateToProducts(){
		Products.click();
	}

	/**
	 * Navigate to Email
	 */
	public void navigateToEmail(){
		Email.click();
	}

	/**
	 * Navigate to Dashboard
	 */
	public void navigateToDashboard(){
		Dashboard.click();
	}

	/**
	 * Navigate to More
	 */
	public void navigateToMore(){
		act.moveToElement(More).perform();;
	}

	/**
	 * Navigate to Reports
	 */
	public void navigateToReports(){
		Reports.click();
	}

	/**
	 * Navigate to SMSNotifier
	 */
	public void navigateToSMSNotifier(){
		SMSNotifier.click();
	}

	/**
	 * Navigate to Comments
	 */
	public void navigateToComments(){
		Comments.click();
	}

	/**
	 * Navigate to Quotes
	 */
	public void navigateToQuotes(){
		Quotes.click();
	}

	/**
	 * Signout of the application
	 */
	public void signOut(){
		act.moveToElement(admin).perform(); 
		Sign_Out.click();
	}
	
	/**
	 * Open preferences
	 */
	public void My_Preferences(){
		act.moveToElement(admin).perform();
		My_Preferences.click();
	}

	/**
	 * Opens Help
	 */
	public void Help(){
		act.moveToElement(info_img);
		Help.click();
	}
	
	/**
	 * Opens Settings
	 */
	public void CRM_Settings(){
		act.moveToElement(setting_img);
		CRM_Settings.click();
	}
}
