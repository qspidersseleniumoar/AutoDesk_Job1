package com.autodesk.crm.campaigntest.scripts.opportunities;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.opportunities.OpportunitiesPage;
/**
 * 
 * @author Tess
 * Adding Documents With SelectDocuments To Created Opportunity
 */
public class AddingDocumentsWithSelectDocumentsToCreatedOpportunityTest extends BaseClass {
			@Test
			public void createOpportunityAssignToGroupTest() throws Throwable {
				 OpportunitiesPage oppurtunitiesPage =homePage.navigateToOpportunities();
		         oppurtunitiesPage.addingDocumentsWithSelectDocumentsToCreatedOpportunity();             
		}

}