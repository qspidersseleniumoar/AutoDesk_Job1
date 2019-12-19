package com.autodesk.crm.campaigntest.scripts.quotations;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.objectrepository.quotations.CreateQuotePage;

/***
 * 
 * @author Pradeep Sharma
 *
 */
public class CreateQuoteWithStageRejectedTest extends BaseClass {
	CreateQuotePage quotesPage;

	@Test
	public void CreateQuoteWithStageRejected() throws Throwable {
		quotesPage = new CreateQuotePage(driver);
		homePage.navigateToMore();
		homePage.navigateToQuotes();
		quotesPage.CreateQuoteWithStageRejected();
		quotesPage.verifyCreateQuoteWithStageRejected();
	}
}
