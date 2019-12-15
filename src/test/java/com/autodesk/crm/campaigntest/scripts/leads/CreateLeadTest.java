package com.autodesk.crm.campaigntest.scripts.leads;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.leads.LeadsPage;


/**
 * 
 * @author Deepak
 *
 */

public class CreateLeadTest extends BaseClass{
	/**
	 * @throws Throwable 
	 */
	@Test
	public void createLead() throws Throwable{
		/*1. Go to leads page*/
		LeadsPage leadsPage = homePage.navigateToLeads();
		
		
		/*Click the plus button to create lead and enter valid data and save*/
		leadsPage.createUsingPlus();
	}
}
