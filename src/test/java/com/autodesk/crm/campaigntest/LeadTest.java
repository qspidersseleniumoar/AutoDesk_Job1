package com.autodesk.crm.campaigntest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.LeadsPage;

/**
 * 
 * @author Deepak
 *
 */

@Listeners(com.autodesk.crm.commonlib.Listener.class)
public class LeadTest extends BaseClass{
	/**
	 * @author Ramya
	 */
	@Test
	public void createLead(){
		
		/*1. Go to leads page*/
		LeadsPage leadsPage = homePage.navigateToLeads();
		leadsPage.createLeadUsingPlus();
		/*2. Click on create lead*/
		
	}
}
