package com.autodesk.crm.campaigntest.scripts.leads;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.leads.LeadsPage;

/**
 * 
 * @author Ramya
 *
 */
public class BulkCreateLeadTest extends BaseClass{
	
	/**
	 * Create 20 leads in bulk by reading data from excel
	 * @param firstname
	 * @param lastname
	 * @param company
	 * @throws Throwable
	 */
	@Test(dataProviderClass = com.autodesk.crm.dataproviders.leads.LeadsData.class,
			dataProvider = "create20Leads")
	public void createLead(String firstname, String lastname, String company) throws Throwable {
		LeadsPage leadsPage = homePage.navigateToLeads();
		
		/*Click the plus button to create lead and enter valid data and save and repeat the process multiple times*/
		leadsPage.createBulkUsingPlus(firstname, lastname, company);
	}

}
