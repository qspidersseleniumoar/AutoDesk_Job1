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
public class DeleteMultipleOrganizationFromHeaderTest extends BaseClass{

	@Test
	public void deleteMultipleOrganizationFromHeaderTest() throws Throwable {
		
		/* Navigate to Organizations Page */
		OrganizationPage orgPage = homePage.navigateToOrganizations();
		
		/* Navigate to Creating new Organization Page */
		CreatingNewOrganizationPage createOrgPage = orgPage.navigateToCreatingNewOrganization();
		
		/* Creating new Organization */
		createOrgPage.createOrgWithName("Sheet1", 13, 3);
		
		/* Navigating back to Organizations */
		homePage.getOrganizationsTab();
		
		/* Get the Alert popup MSg when we click on Mass delete button */
		String actAlertMsg = orgPage.acceptMassDel();
		
		
		/* Get the expected Alert Message from Excel */
		String expAlertMsg = orgPage.getExcelData("Sheet1", 13, 4);
				
		/* Validate */
		Assert.assertTrue(actAlertMsg.contains(expAlertMsg));
	}
}
