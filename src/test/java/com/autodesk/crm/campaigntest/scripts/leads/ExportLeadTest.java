package com.autodesk.crm.campaigntest.scripts.leads;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.leads.LeadsPage;

/**
 * 
 * @author Ramya
 *
 */
public class ExportLeadTest extends BaseClass{
	
	/**
	 * Gets the lead information and writes to excel
	 * Simple test to check if write operation can be performed to excel
	 * @throws Throwable
	 */
	@Test
	public void getLead() throws Throwable{
		/*1. Go to leads page*/
		LeadsPage leadsPage = homePage.navigateToLeads();
		
		/*Click the plus button to create lead and enter valid data and save*/
		leadsPage.feedInfo();
	}

}
