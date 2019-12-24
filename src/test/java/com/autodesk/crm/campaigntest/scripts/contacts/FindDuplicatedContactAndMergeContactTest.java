package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;
/**
 * 
 * @author Ramakanth
 * used to find the duplicate contacts and try to merge without 
 * selecting contacts and capture the alert pop up message
 */
public class FindDuplicatedContactAndMergeContactTest extends BaseClass {
	@Test
	public void findDuplicatedContactAndMergeContactTest() throws Throwable {
		/*Navigate to contacts page*/
		ContactsPage cp=homePage.navigateToContacts();
		
		
		/*create two contacts*/
		cp.createOnlyLastname("Sheet2", 6, 3);
		cp.createOnlyLastname("Sheet2", 7, 3);
		cp.createOnlyLastname("Sheet2", 8, 3);

		
		/*navigate back to contacts*/
		cp.navigateToContacts();
		
		/*click on find duplicates image and find duplicates using search criteria*/
		cp.findDuplicates(cp.getData("Sheet2", 6, 5));
		
		/*select one contact to merge*/
		cp.selectDuplicateMergeChkBx();
		
		/*click on merge button, capture the alert message and accept */
		String actMsg=cp.clickDupliMergeBtn();
		String expMsg=cp.getData("Sheet2", 6, 6);
		Assert.assertEquals(actMsg, expMsg);
		
		/*Validate whether Duplicate Contacts page displayed or not*/
		String actPage=cp.duplicateContactPage();
		String expPage=cp.getData("Sheet2", 6, 7);
		Assert.assertEquals(actPage, expPage);
	}

}
