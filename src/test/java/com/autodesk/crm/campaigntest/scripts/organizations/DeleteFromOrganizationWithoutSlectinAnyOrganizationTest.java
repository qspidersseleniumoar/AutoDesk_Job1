package com.autodesk.crm.campaigntest.scripts.organizations;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.organizations.OrganizationPage;

/**
 * 
 * @author adikiprakash
 *
 */
public class DeleteFromOrganizationWithoutSlectinAnyOrganizationTest extends BaseClass {

	@Test
	public void deleteFromOrganizationWithoutSlectinAnyOrganizationTest() throws Throwable {
		
		/* Go to Organization Page */
		OrganizationPage orgPage = homePage.navigateToOrganizations();
		
		/* Click on Delete Button & Fetch Alert Msg*/
		String actAlertMsg = orgPage.deleteHead();
		
		/* Get the expected Alert Message from Excel */
		String expAlertMsg = orgPage.getExcelData("Sheet1", 1, 3);
		
		/* Validate */
		Assert.assertEquals(actAlertMsg, expAlertMsg);
	}
}
