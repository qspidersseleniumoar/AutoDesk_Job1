package com.autodesk.crm.campaigntest.scripts.quotations;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.quotations.CreateQuotePage;

/***
 * 
 * @author Pradeep Sharma
 *
 */
public class CreateQuoteWithContactTest extends BaseClass {

	CreateQuotePage quotesPage;

	@Test

	public void CreateQuoteWithContact() throws Throwable {
		quotesPage = new CreateQuotePage(driver);
		homePage.navigateToMore();
		homePage.navigateToQuotes();
		quotesPage.CreateQuoteWithContact();

	}
}
