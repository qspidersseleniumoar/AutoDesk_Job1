package com.autodesk.crm.campaigntest.scripts.leads;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.leads.LeadsPage;

/**
 * 
 * @author Ramya
 *
 */
public class MassDeleteTest extends BaseClass{
	
	/**
	 * Mass delete contacts
	 * @throws Throwable
	 */
	@Test
	public void massDeleteLead() throws Throwable{
		/*1. Go to leads page*/
		LeadsPage leadsPage = homePage.navigateToLeads();
		
		/*Click of plus button to create lead and enter valid data and save*/
		leadsPage.deleteMultiple();
	}

}
