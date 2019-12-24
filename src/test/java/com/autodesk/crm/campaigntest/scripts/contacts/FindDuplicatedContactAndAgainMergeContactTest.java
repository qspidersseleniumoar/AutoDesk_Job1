package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;

public class FindDuplicatedContactAndAgainMergeContactTest extends BaseClass{
	
	@Test
	public void findDuplicatedContactAndAgainMergeContactTest() throws Throwable {
		/*Navigate to contacts page*/
		ContactsPage cp=homePage.navigateToContacts();
		
		
		/*create three contacts*/
		cp.createOnlyLastname("Sheet2", 26, 3);
		
		cp.createOnlyLastname("Sheet2", 27, 3);
		
		cp.createOnlyLastname("Sheet2", 28, 3);
		

		
		/*navigate back to contacts*/
		cp.navigateToContacts();
		
		/*click on find duplicates image and find duplicates using search criteria*/
		cp.findDuplicates("Last Name");
		
		/*click merge button and accept*/
		String actMsg1=cp.clickDupliMergeBtn();
		String expMsg1=cp.getData("Sheet2", 26, 6);
		Assert.assertEquals(actMsg1, expMsg1);
		
		/*click merge button and accept*/
		String actMsg2=cp.clickDupliMergeBtn();
		String expMsg2=cp.getData("Sheet2", 26, 6);
		Assert.assertEquals(actMsg2, expMsg2);
		
		/*validate whether duplicate contact page is displayed or not*/
		String actPage=cp.duplicateContactPage();
		String expPage=cp.getData("Sheet2", 26, 7);
		Assert.assertEquals(actPage, expPage);
	}

}
