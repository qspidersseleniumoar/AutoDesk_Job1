package com.autodesk.crm.campaigntest.scripts.opportunities;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;

import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
public class CreateOpportunityAssignToGroupTest extends BaseClass {
	/**
	 * @author Tess
	 * createOpportunityAssignToGroup
	 * @throws Throwable
	 */
	@Test
	public void createOpportunityAssignToGroup() throws Throwable {

		OpportunitiesPage oppurtunitiesPage = homePage.navigateToOpportunities();
		oppurtunitiesPage.createOpportunitWithGroup();
		oppurtunitiesPage.verifyOpportunitwithGroup();
		
	}
//		
}
