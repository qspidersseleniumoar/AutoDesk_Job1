package com.autodesk.crm.campaigntest.scripts.organizations;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.leads.LeadsPage;
import com.autodesk.crm.objectrepository.organizations.CreatingNewOrganizationPage;
import com.autodesk.crm.objectrepository.organizations.OrganizationPage;
/**
 * 
 * @author Sathya
 *
 */

public class CreateOrganizationTest extends BaseClass{
	/**
	 * @throws Throwable 
	 */
	@Test
	public void createOrganization() throws Throwable{
		/*1. Go to Organization page*/
		OrganizationPage orgsPage = homePage.navigateToOrganizations();
		
		
		/*2.Click the plus button to create organization and enter valid data and save*/
		CreatingNewOrganizationPage crtorg = orgsPage.navigateToCreatingNewganization();
		crtorg.createOrgWithName("Sheet1", 0, 0);
	    crtorg.enterorg();
	    crtorg.clicksavebtn();
	    Thread.sleep(2000);
	    crtorg.successmsgvalidation();
		
	
	}
}
