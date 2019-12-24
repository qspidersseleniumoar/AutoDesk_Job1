package com.autodesk.crm.campaigntest.scripts.opportunities;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
/**
 * 
 * @author Tess
 * Search Opportunity By OpportunityNo EndsWith
 */
public class SearchOpportunityByOpportunityNoEndsWithTest extends BaseClass{
	@Test
	public void searchOpportunityByOpportunityNo() throws Throwable {
		
		 OpportunitiesPage oppurtunitiesPage =homePage.navigateToOpportunities();
         oppurtunitiesPage.searchOpportunityByOpportunitynoEndsWith();
	}

}
