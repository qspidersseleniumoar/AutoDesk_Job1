package com.autodesk.crm.campaigntest.scripts.contacts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.common.HomePage;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;

public class OpenContactAndDeleteThatContactAndCancelTest extends BaseClass
{
	WebDriver driver = null;
	@Test
	public void OpenContactAndDeleteContactAndCancelTest() throws Throwable
	{
		ContactsPage contact = homePage.navigateToContacts();
		Thread.sleep(5000);
		contact.OpenContactAndDeleteThatContactAndCancel();
		
		
	}
}
