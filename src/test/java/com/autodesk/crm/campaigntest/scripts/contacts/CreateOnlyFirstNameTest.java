package com.autodesk.crm.campaigntest.scripts.contacts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.objectrepository.contacts.ContactsPage;

public class CreateOnlyFirstNameTest extends BaseClass {
	CommonLibrary commonlib;

	@Test
	public void createOnlyFirstName() throws Throwable {
		commonlib = new CommonLibrary(driver);
		ContactsPage contact = homePage.navigateToContacts();
		contact.createOnlyFirstName();
		String msg = commonlib.acceptAlert();
		Reporter.log(msg, true);

	}
}
