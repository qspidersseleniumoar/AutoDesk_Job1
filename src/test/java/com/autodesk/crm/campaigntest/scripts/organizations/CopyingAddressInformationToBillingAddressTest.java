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
public class CopyingAddressInformationToBillingAddressTest extends BaseClass{

	@Test
	public void copyingAddressInformationToBillingAddressTest() throws Throwable {
		
		/* Navigate to Organizations Page */
		OrganizationPage orgPage = homePage.navigateToOrganizations();
		
		/* Navigate to Creating new Organization Page */
		CreatingNewOrganizationPage createOrgPage = orgPage.navigateToCreatingNewOrganization();
		
		String expAdress = createOrgPage.copyBillAdToShipAd("Sheet1", 22, 3);
		
		String actAdress = createOrgPage.shipAdreesInfo();
		
		Assert.assertEquals(actAdress, expAdress);
		
		
		
		
	}
}
