package com.autodesk.crm.campaigntest.scripts.opportunities;


import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
import com.autodesk.crm.objectrepository.common.HomePage;
import org.testng.annotations.Test;
/**
 * 
 * @author Anju
 *
 */
public class CreateOpportunitiesTest extends BaseClass {
	@Test
	public void CreateOpportunities() throws Throwable{
		/*1. Go to Opportunities page*/
		OpportunitiesPage opportunitiesPage = homePage.navigateToOpportunities();
	
		/*Click the plus button to create Opportunity and enter valid data and save*/
		
		opportunitiesPage.createUsingPlus();
		
		/* and verify the Opportunity name&CampaignSource  in Opportunity info Page*/
		opportunitiesPage.validatingOpportunityAndCampaignSource();
	}
	
	/* AddingSalesStageHistorysToCreatedOpportunity*/
	@Test
	public void AddingSalesStage() throws Throwable{
		OpportunitiesPage opportunitiesPage = homePage.navigateToOpportunities();
		opportunitiesPage.AddingSalesStageHistory();
	}
	
	/*AddingSalesOrderToCreatedOpportunity*/
	@Test
	public void AddingSalesOrder() throws Throwable{
		OpportunitiesPage opportunitiesPage = homePage.navigateToOpportunities();
		opportunitiesPage.AddingSalesOrder();
}
}