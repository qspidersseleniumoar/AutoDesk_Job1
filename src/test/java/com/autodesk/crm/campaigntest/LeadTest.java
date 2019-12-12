package com.autodesk.crm.campaigntest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;

/**
 * 
 * @author Deepak
 *
 */

@Listeners(com.autodesk.crm.commonlib.Listener.class)
public class LeadTest extends BaseClass{
	@Test
	public void createLead(){
		
		/*1. Go to leads page*/
		homePage.navigateToLeads();
		
		/*2. Click on create lead*/
		
	}
}
