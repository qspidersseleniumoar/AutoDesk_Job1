package com.autodesk.crm.objectrepository.opportunities;


import static com.autodesk.crm.commonlib.ExcelLib.closeBook;
import static com.autodesk.crm.commonlib.ExcelLib.getData;
import static com.autodesk.crm.commonlib.ExcelLib.openSheet;

import java.util.Random;

import javax.management.monitor.MonitorSettingException;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.IFilePaths;


//github.com/qspidersseleniumoar/AutoDesk_Job1.git


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.autodesk.crm.commonlib.ExcelLib.openSheet;
import static com.autodesk.crm.commonlib.ExcelLib.getData;
import static com.autodesk.crm.commonlib.ExcelLib.closeBook;
import static com.autodesk.crm.commonlib.ExcelLib.setData;
import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.IFilePaths;
import com.autodesk.crm.objectrepository.common.HomePage;
import com.google.common.base.Verify;

import org.testng.asserts.SoftAssert;

public class OpportunitiesPage implements IFilePaths  {
	
		private WebDriver driver;
		private CommonLibrary common;
		private HomePage homePage;
		/*Creating opportunity and validating opportunity info page*/
		/**
		 * @author Anju
		 */
		@FindBy(xpath="//img[@title='Create Opportunity...']") private WebElement plusBtn;
		@FindBy(xpath="//input[@name='potentialname']")private WebElement OpportunityName; 
		@FindBy(xpath="//select[@name='sales_stage']") private WebElement SalesStage;
		@FindBy(xpath="(//img[contains(@src,'select.gif')])[2]") private WebElement CampaignSourceBtn;
		@FindBy(xpath="//a[@id='1']") private WebElement CampaignSource;
		@FindBy(xpath="(//img[contains(@src,'select.gif')])[1]") private WebElement RelatedToPlusBtn;
		@FindBy(xpath="//a[@id='1']") private WebElement RelatedTo;
		@FindBy(xpath="(//input[@class='crmbutton small save'])[1]") private WebElement saveBtn;
		@FindBy(xpath="//span[@id='dtlview_Opportunity Name']")private WebElement OpportunityNameField;
		@FindBy(xpath="(//td[@class='dvtCellInfo'])[11]") private WebElement CampaignSourceField;
		
		
		@FindBy(xpath="(//a[@title='Opportunities'])[1]") private WebElement opportunity;
		//@FindBy(xpath="(//a[.='More Information'])[1]") private WebElement moreInformation;
		@FindBy(xpath="//a[.='Sales Stage History']") private WebElement salesStageHistory;
		@FindBy(xpath="(//a[.='Sales Order'])[2]") private WebElement salesOrder;
		@FindBy(xpath="//input[@title='Add Sales Order']") private WebElement addSalesOrder;
		@FindBy(xpath="//input[@name='subject']") private WebElement subject;
		@FindBy(xpath="//img[@id='searchIcon1']") private WebElement itemIcon;
		@FindBy(xpath="//a[@id=\"popup_product_52\"]") private WebElement productName;
		@FindBy(xpath="//input[@id='qty1']") private WebElement qty;
		@FindBy(xpath = "//img[@alt='Create Opportunity...']")
		private WebElement plusButton;
/**
 * @author Tess
 */
		@FindBy(xpath="//input[@class='detailedViewTextBox']")  
		private WebElement opportunityName;
		
		@FindBy(xpath="//td[@id='mouseArea_Opportunity Name']/span")
		private WebElement opSearch;
		
		
		@FindBy(id = "jscal_field_closingdate")
		private WebElement expectedCloseDate;

		@FindBy(xpath = "//input[@value='T']")
		private WebElement groupRadioButton;

		@FindBy(name = "assigned_group_id")
		private WebElement assignGroupID;

		@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
		private WebElement relatedTo;

		@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[2]")
		private WebElement campaignSource;

		@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
		private WebElement saveButton;

	/*	@FindBy(xpath = "//td[@class='moduleName']")
		private WebElement childTitle;*/

		@FindBy(xpath = "//a[@href='javascript:window.close();']")
		private WebElement clickOrganisation;

		@FindBy(xpath = "//a[text()='Go to Advanced Search']")
		private WebElement advsearch;

		@FindBy(xpath = "//a[@href='javascript:;']")
		private WebElement clickcampaign;
		
		@FindBy(xpath="//a[@href='index.php?module=Settings&action=GroupDetailView&groupId=3']")
		private WebElement groupID;
		//edit xpath
		
		@FindBy(xpath="//a[@href='index.php?module=Potentials&parenttab=Sales&action=DetailView&record=3']")
		private WebElement editOpportunity;
		@FindBy(xpath="//a[@href='index.php?action=CallRelatedList&module=Potentials&record=3&parenttab=Sales']")
		private WebElement moreInformation;
		@FindBy(xpath="//a[@href='index.php?action=CallRelatedList&module=Potentials&record=3&parenttab=Sales&selected_header=Documents&relation_id=34']")
		private WebElement documents;
		//search xpath
		/**
		 * @author Tess
		 */
		@FindBy(xpath="//select[@name='fcol0']")
		private WebElement searchOppName;
		@FindBy(xpath="//select[@name='fop0']")
		private WebElement anotherDropDown;
		@FindBy(xpath="//input[@name='fval0']")
		private WebElement opportunityrelatedTBx;
		@FindBy(xpath="(//input[@value=' Search Now '])[2]")
		private WebElement searchNow;
		//edit opportunity
		/**
		 * @author Tess
		 */
		@FindBy(xpath="//input[@title='Select Documents']")
		private WebElement selectDocumentsBtn;
		@FindBy(xpath="//a[text()='adhaar']")
		private WebElement adhaar;
		@FindBy(xpath="//input[@title='Add Document']")
		private WebElement addDocumentsBtn;
		@FindBy(xpath="//input[@class='detailedViewTextBox']")
		private WebElement documentTitle;
		@FindBy(xpath="//input[@id='filename_I__']")
		private WebElement choosefileBtn;
		/**
		 * @author Tess 
		 * Create an opportunity using the plus button by reading data from
		 *         an excel sheet one record at a time
		 * @throws Throwable
		 */
		public void createOpportunitWithGroup() throws Throwable {
			plusButton.click();
			openSheet(OPP, "Create");
			opportunityName.sendKeys(getData(1, 0));
			relatedTo.click();
			common.switchToChildWindow();
			clickOrganisation.click();
			common.switchToParentWindow();
			groupRadioButton.click();
			closeBook();
			saveButton.click();
		}

		/**
		 * @author Tess 
		 * Create an opportunity with campaign name
		 * @throws Throwable
		 */
		public void createOpportunityWithCampaign() throws Throwable// testcase 191

		{
			plusButton.click();
			openSheet(OPP, "Create");
			opportunityName.sendKeys(getData(1, 0));
			relatedTo.click();
			common.switchToChildWindow();
			clickOrganisation.click();
			common.switchToParentWindow();
			campaignSource.click();
			common.switchToChildWindow();
			clickcampaign.click();
			common.switchToParentWindow();
			closeBook();
			saveButton.click();

		}
		/**
		 * @author Tess
		 * This method is for search Opportunity by Relatadto option
		 * @throws Throwable
		 */
		public void searchOpportunityByRelatadto() throws Throwable//238
		{
			advsearch.click();
			openSheet(OPP, "Create");
			common.selectOption(searchOppName, getData(1, 3));
			common.selectOption(anotherDropDown, getData(1,4));
			opportunityrelatedTBx.sendKeys(getData(1, 5));
			common.waitAndClick(searchNow);
			closeBook();
			
		}
		/**
		 * @author Tess
		 * @throws Throwable 
		 * This method is for searching Opportunity By Opportunityno ends with options
		 */
		public void searchOpportunityByOpportunitynoEndsWith() throws Throwable//225
		{
			advsearch.click();
			openSheet(OPP, "Create");
			common.selectOption(searchOppName, getData(2, 3));
			common.selectOption(anotherDropDown, getData(2,4));
			opportunityrelatedTBx.sendKeys(getData(2, 5).toString());
			common.waitAndClick(searchNow);
			closeBook();
			
		}
		/**
		 * @author Tess
		 * This method is for searching Opportunity By Opportunityno starts with options
		 * @throws Throwable 
		 */
		public void searchOpportunityByOpportunitynoStartsWith() throws Throwable//224
		{
			advsearch.click();
			openSheet(OPP, "Create");
			common.selectOption(searchOppName, getData(2, 3));
			common.selectOption(anotherDropDown, getData(3,4));
			opportunityrelatedTBx.sendKeys(getData(3, 5));
			common.waitAndClick(searchNow);
			closeBook();
			
		}
		/**
		 * 
		 * @author Tess
		 * This method is for adding documents with select documents to created Opportunity
		 */
		
		public void addingDocumentsWithSelectDocumentsToCreatedOpportunity() //198
		{
			editOpportunity.click();
			Actions act = new Actions(driver);
			act.moveToElement(moreInformation).perform();
			documents.click();
			selectDocumentsBtn.click();
			common.switchToChildWindow();
			adhaar.click();
			
		}
		/**
		 * @author Tess
		 * This method is for searching Opportunity By Opportunityno starts with options
		 * @throws Throwable
		 */
		public void addingDocumentsWithAddDocumentsToCreatedOpportunity() throws Throwable //199
		{
			editOpportunity.click();
			Actions act = new Actions(driver);
			act.moveToElement(moreInformation).perform();
			documents.click();
			addDocumentsBtn.click();
			openSheet(OPP, "Create");
			documentTitle.sendKeys(getData(1,6));
			choosefileBtn.sendKeys(getData(1, 7));
			saveButton.click();
			closeBook();
			
		}
			
			

		/**
		 * 
		 * @author Tess
		 * Initiate the opportunities page
		 * @param driver
		 */
		public OpportunitiesPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
			common = new CommonLibrary(driver);
		}

		/**
		 * @author Tess 
		 * validation of opportunity creating with group
		 * @throws Throwable
		 */
		public void verifyOpportunitwithGroup() throws Throwable {
			String actual = opSearch.getText();
			String expected = getData(1, 0);
			Assert.assertEquals(actual, expected);
			String actual1 = groupID.getText();
			String expected1 = getData(1, 1);
			Assert.assertEquals(actual1, expected1);
			closeBook();

		}
		/**
		 * @author Anju
		 * create new Opportunity by using '+' button by reading data from excel sheet
		 * @throws Throwable 
		 */
		
		public void createUsingPlus() throws Throwable {
			plusBtn.click();
			/*fetching data from excel sheet*/
			openSheet(OPP, "create");
			OpportunityName.sendKeys(getData(1, 0));
			
			String data=getData(1,1);
			common.selectOption(SalesStage, data);
			
			/* fill the data in related to field*/
			 
			RelatedToPlusBtn.click();
			common.switchToChildWindow();
			RelatedTo.click();
			common.switchToParentWindow();
			
			/* fill the data in CampaignSource field*/
			CampaignSourceBtn.click();
			common.switchToChildWindow();
			CampaignSource.click();
			common.switchToParentWindow();
			
			closeBook();
			saveBtn.click();
		}
		
		
			
			/**
			 * verify the Opportunity name&CampaignSource  in Opportunity info Page 
			 * @throws  
			 */	
		public void validatingOpportunityAndCampaignSource() throws Throwable {
			createUsingPlus();
			common.waitForPageToLoad();
			common.waitForElemetToBePresent(OpportunityNameField);
		String ActualOpportunityName=OpportunityNameField.getText();
		//System.out.println("ActualOpportunityName"+ActualOpportunityName);
		openSheet(OPP, "create");
		String Expected1=getData(1,0);
		//System.out.println(Expected1);
		Assert.assertEquals(ActualOpportunityName, Expected1);
		String  Actualcampaignsource=CampaignSourceField.getText();
		//System.out.println("Actualcampaignsource"+Actualcampaignsource);
		
		String Expected=getData(1,2);
		//System.out.println(Expected);
		closeBook();
		Assert.assertEquals(Actualcampaignsource, Expected);
									
		}
		
		
		/* AddingSalesStageHistorysToCreatedOpportunity*/
		public void AddingSalesStageHistory() throws Throwable {
			opportunity.click();
			common.waitForPageToLoad();
			Actions act=new Actions (driver);
			act.moveToElement(moreInformation).perform();
						
			salesStageHistory.click();
		
		}
	/*AddingSalesOrderToCreatedOpportunity*/
		public void AddingSalesOrder() throws Throwable {
			opportunity.click();
			common.waitForPageToLoad();
			Actions act=new Actions (driver);
			act.moveToElement(moreInformation).perform();
						
			salesOrder.click();
			addSalesOrder.click();
			
			openSheet(OPP, "create");
			subject.sendKeys(getData(1, 3));
			
			itemIcon.click();
			common.switchToChildWindow();
			//productName.click();
			common.waitAndClick(productName);
			 qty.sendKeys("4");
			//
		
			saveBtn.click();
			closeBook();
		}
		
		
		
	
}


