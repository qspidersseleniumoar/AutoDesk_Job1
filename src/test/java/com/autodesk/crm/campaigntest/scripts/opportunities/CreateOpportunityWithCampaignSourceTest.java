package com.autodesk.crm.campaigntest.scripts.opportunities;
import org.testng.annotations.Test;
import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
/**
 * 
 * @author Tess
 *CreateOpportunityWithCampaignSource
 */
public class CreateOpportunityWithCampaignSourceTest extends BaseClass {
	@Test
	public void createOpportunityAssignToGroupTest() throws Throwable {
		 OpportunitiesPage oppurtunitiesPage =homePage.navigateToOpportunities();
		 oppurtunitiesPage.createOpportunityWithCampaign();           

 }
}
