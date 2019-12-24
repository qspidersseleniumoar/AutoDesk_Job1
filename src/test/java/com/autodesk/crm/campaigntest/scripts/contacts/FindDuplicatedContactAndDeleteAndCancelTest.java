package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;

public class FindDuplicatedContactAndDeleteAndCancelTest extends BaseClass {
	@Test
	public void findDuplicatedContactAndDeleteAndCancelTest() throws Throwable {
		/*Navigate to contacts page*/
		ContactsPage cp=homePage.navigateToContacts();
		
		
		/*create two contacts*/
		cp.createOnlyLastname("Sheet2", 11, 3);
		cp.createOnlyLastname("Sheet2", 12, 3);
		cp.createOnlyLastname("Sheet2", 13, 3);

		
		/*navigate back to contacts*/
		cp.navigateToContacts();
		
		/*click on find duplicates img and find duplicates using search criteria*/
		
		cp.findDuplicates(cp.getData("Sheet2", 11, 5));
		
		/*Select the duplicated contacts and delete*/
		cp.selectDupliChkBx();
		
		/*delete duplicate contacts*/
		String actMsg = cp.deleteDulicateCancel();
		String dupliCnt=cp.delDupCount(actMsg);
		
		System.out.println(actMsg);
		System.out.println(dupliCnt);
		
		String expMsg=cp.getData("Sheet2", 11, 6);
		Assert.assertTrue(actMsg.contains(expMsg));
		
		/*Validate whether Duplicate Contacts page displayed or not*/
		String actPage=cp.duplicateContactPage();
		
		System.out.println(actPage);
		
		String expPage=cp.getData("Sheet2", 11, 7);
		Assert.assertEquals(actPage, expPage);
	}


}
