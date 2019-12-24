package com.autodesk.crm.campaigntest.scripts.quotations;

import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.objectrepository.quotations.CreateQuotePage;
import com.autodesk.crm.objectrepository.quotations.ValidateQuotePage;

/**
 * 
 * @author Vinita
 *
 */
public class CreateQuoteWithStageDeliveredTest extends BaseClass {
	CreateQuotePage createQuotePage;
	ExcelLib excelLib;
	CommonLibrary commonLib;
	ValidateQuotePage validateQuotePage;

	@Test
	public void createQuoteWithStageDelivered() throws Throwable {
		CreateQuotePage createQuotePage = homePage.navigateToQuotes();
		createQuotePage.createQuoteWithStageDelivered();

		ValidateQuotePage validateQuotePage = new ValidateQuotePage(driver);
		homePage.navigateToQuotes();
		validateQuotePage.verifySubQuoteStage2();
	}
}
