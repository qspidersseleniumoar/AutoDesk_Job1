package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;

/**
 * 
 * @author Gowri
 *
 */

public class CreateOnlyLastNameTest extends BaseClass
{
	@Test
	public void createOnlyLastname() throws Throwable
	{
		ContactsPage contact = homePage.navigateToContacts();
		contact.createOnlyLastname();
	}
}
