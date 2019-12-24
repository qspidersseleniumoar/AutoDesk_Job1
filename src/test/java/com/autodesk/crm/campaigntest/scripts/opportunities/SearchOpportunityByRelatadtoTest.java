package com.autodesk.crm.campaigntest.scripts.opportunities;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
/**
 * 
 * @author Tess
 * SearchOpportunityByRelatadto
 */
public class SearchOpportunityByRelatadtoTest extends BaseClass {
		@Test
		public void searchOpportunityByRelatadto() throws Throwable {
			
			 OpportunitiesPage oppurtunitiesPage =homePage.navigateToOpportunities();
	         oppurtunitiesPage.searchOpportunityByRelatadto();
		}
}
