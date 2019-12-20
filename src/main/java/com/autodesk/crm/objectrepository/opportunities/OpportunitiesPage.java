package com.autodesk.crm.objectrepository.opportunities;



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
/**
 * 
 * @author Anju
 *
 */

public class OpportunitiesPage implements IFilePaths  {
	
		private WebDriver driver;
		private CommonLibrary common;
		private HomePage homePage;
		/*Creating opportunity and validating opportunity info page*/
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
		@FindBy(xpath="(//a[.='More Information'])[1]") private WebElement moreInformation;
		@FindBy(xpath="//a[.='Sales Stage History']") private WebElement salesStageHistory;
		@FindBy(xpath="(//a[.='Sales Order'])[2]") private WebElement salesOrder;
		@FindBy(xpath="//input[@title='Add Sales Order']") private WebElement addSalesOrder;
		@FindBy(xpath="//input[@name='subject']") private WebElement subject;
		@FindBy(xpath="//img[@id='searchIcon1']") private WebElement itemIcon;
		@FindBy(xpath="//a[@id=\"popup_product_52\"]") private WebElement productName;
		@FindBy(xpath="//input[@id='qty1']") private WebElement qty;
		
		/**
		 * Initiate OpportunitiesPage
		 * @param driver
		 */
		public OpportunitiesPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			this.driver=driver;
			common = new CommonLibrary(driver);
			
		}
		/**
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


