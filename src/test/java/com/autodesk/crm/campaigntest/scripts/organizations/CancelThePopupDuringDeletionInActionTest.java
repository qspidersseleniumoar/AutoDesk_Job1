package com.autodesk.crm.campaigntest.scripts.organizations;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.organizations.CreatingNewOrganizationPage;
import com.autodesk.crm.objectrepository.organizations.OrganizationPage;

/**
 * 
 * @author adikiprakash
 *
 */
public class CancelThePopupDuringDeletionInActionTest extends BaseClass{

	@Test
	public void cancelThePopupDuringDeletionInActionTest() throws Throwable {
		
		
		
		/* Navigate to Organizations Page */
		OrganizationPage orgPage = homePage.navigateToOrganizations();
		
		/* Navigate to Creating new Organization Page */
		CreatingNewOrganizationPage createOrgPage = orgPage.navigateToCreatingNewOrganization();
		
		/* Creating new Organization */
		createOrgPage.createOrgWithName("TYC111973", 4, 3);
		
		/* Navigating back to Organizations */
		homePage.getOrganizationsTab();
		
		/* Get the Alert popup MSg when we click on delete link */
		String actAlertMsg = orgPage.cancelDeleteOne();
		
		/* Get the expected Alert Message from Excel */
		String expAlertMsg = orgPage.getExcelData("TYC111973", 4, 4);
		
		/* Validate */
		Assert.assertEquals(actAlertMsg, expAlertMsg);
		
	}
}
