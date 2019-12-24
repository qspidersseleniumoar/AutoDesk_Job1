package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;
/**
 * 
 * @author Ramakanth
 * used to find duplicate contact and delete the duplicated contacts
 *
 */
public class FindDuplicatedContactAndDeleteTheContactTest extends BaseClass{
	
		@Test
		public void findDuplicatedContactAndDeleteTheContactTest() throws Throwable {
			/*Navigate to contacts page*/
			ContactsPage cp=homePage.navigateToContacts();
			
			
			/*create two contacts*/
			cp.createOnlyLastname("Sheet2", 1, 3);
			cp.createOnlyLastname("Sheet2", 2, 3);
			cp.createOnlyLastname("Sheet2", 3, 3);

			
			/*navigate back to contacts*/
			cp.navigateToContacts();
			
			/*click on find duplicates img and find duplicates using search criteria*/
			
			cp.findDuplicates(cp.getData("Sheet2", 1, 5));
			
			/*Select the duplicated contacts and delete*/
			cp.selectDupliChkBx();
			
			/*delete duplicate contacts*/
			String actMsg = cp.deleteDulicate();
			String dupliCnt=cp.delDupCount(actMsg);
			System.out.println(dupliCnt);
			String expMsg=cp.getData("Sheet2", 1, 6);
			Assert.assertTrue(actMsg.contains(expMsg));
		}
		
}
