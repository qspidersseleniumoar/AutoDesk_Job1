package com.autodesk.crm.objectrepository.quotations;

import static com.autodesk.crm.commonlib.ExcelLib.closeBook;
import static com.autodesk.crm.commonlib.ExcelLib.getData;
import static com.autodesk.crm.commonlib.ExcelLib.openSheet;

import java.awt.Window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.IAutoConstants;
import com.autodesk.crm.commonlib.IFilePaths;

/**
 * 
 * @author Rohan
 *
 */
public class CreateQuotePage implements IFilePaths {
	private WebDriver driver;
	private CommonLibrary commonLib;

	@FindBy(xpath = "//img[contains(@src,'btnL3Add.gif')]")
	private WebElement plusBtn;
	@FindBy(name = "subject")
	private WebElement subTB;
	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement orgPlus;
	@FindBy(linkText = "HP")
	private WebElement orgName;
	@FindBy(name = "carrier")
	private WebElement carrierDD;
	@FindBy(name = "bill_street")
	private WebElement billingAdd;
	@FindBy(name = "ship_street")
	private WebElement shipAdd;
	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement prodLookIcon;
	@FindBy(linkText = "Laptop")
	private WebElement prodName;
	@FindBy(id = "ship_state")
	private WebElement shipStateTB;
	@FindBy(id = "qty1")
	private WebElement qtyTB;
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveBtn;
	@FindBy(linkText = "Go to Advanced Search")
	private WebElement gotoAdvanceSearchLink;
	@FindBy(xpath = "(//tr[3]//td[4]//img[1])")
	private WebElement plusOpp;
	/**
	 * @author Vinita
	 */
	@FindBy(xpath = "(//td[5]//table[1]//tbody[1]//tr[1]//td[1]//img[1] )")
	private WebElement listpriceIcon;
	@FindBy(xpath = ("//body/table/tbody/tr/td/form/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/"
			+ "tr/td/table/tbody/tr/td[contains(text(),'(-)')]/b/a[1] "))
	private WebElement discount;
	@FindBy(xpath = ("//a[contains(text(),'Taxes For Shipping and Handling')]"))
	private WebElement taxsSH;
	@FindBy(id = "adjustmentType")
	private WebElement adjustmentDD;
	@FindBy(xpath = ("//body[@class='small']/table/tbody/tr/td[@class='showPanelBg']/form[@id='frmEditView']/div[@class='small']/table/tbody/tr/td/table[@class='dvtContentSpace']/tbody/tr/td/table/tbody/tr/td/table[@class='small']/tbody/tr/td/table"
			+ "[@class='crmTable']/tbody/tr[1]/td[1]/input[1] "))
	private WebElement addProduct;
	@FindBy(xpath = ("//body[@class='small']/table/tbody/tr/td[@class='showPanelBg']/form[@id='frmEditView']/div[@class='small']/table/tbody/tr/td/table[@class='dvtContentSpace']/tbody/tr/td/table/tbody/tr/td/table[@class='small']/tbody/"
			+ "tr/td/table[@class='crmTable']/tbody/tr/td/input[2] "))
	private WebElement addServiceBtn;
	@FindBy(name = "quotestage")
	private WebElement quoteStageDD;
	@FindBy(name = "validtill")
	private WebElement validTillTB;
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement contactNameLookIcon;
	@FindBy(id = "shipping")
	private WebElement shippingTB;
	@FindBy(name = "assigned_user_id1")
	private WebElement inventoryMgrDD;
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement radioBtn;
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToDD;
	@FindBy(name = "description")
	private WebElement descriptionArea;
	@FindBy(xpath = "(//input[@name='button'])[2]")
	private WebElement cancelBtn;
	/**
	 * @author Rohan
	 */
	@FindBy(id = "bill_pobox")
	private WebElement billPOBoxTB;
	@FindBy(id = "bill_city")
	private WebElement billCityTB;
	@FindBy(id = "bill_state")
	private WebElement billStateTB;
	@FindBy(id = "bill_code")
	private WebElement billCodeTB;
	@FindBy(id = "bill_country")
	private WebElement billCountryTB;
	@FindBy(id = "ship_pobox")
	private WebElement shipPOBoxTB;
	@FindBy(id = "ship_city")
	private WebElement shipCityTB;
	@FindBy(id = "ship_code")
	private WebElement shipCodeTB;
	@FindBy(id = "ship_country")
	private WebElement shipCountryTB;
	@FindBy(xpath = "(//input[@name='cpy'])[2]")
	private WebElement copyBillAddRadio;
	@FindBy(xpath = "(//input[@name='cpy'])[1]")
	private WebElement copyShipAddRadio;
	@FindBy(id = "dtlview_Subject")
	private WebElement subjectName;
	@FindBy(linkText = "HP_Sales")
	private WebElement oppoName;

	/**
	 * Initiate the Quotation page
	 * @author Vinita
	 */
	public CreateQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		commonLib = new CommonLibrary(driver);
	}

	/**
	 * Create a Quotation using the plus button by reading data from an excel sheet 
	 * @author Vinita
	 */
	public void createQuoteWithOpportunity() throws Throwable {
		
		String handel = driver.getWindowHandle();
		plusBtn.click();
		openSheet(QTN, "Sheet1");
		subTB.sendKeys(getData(1, 0));
		billingAdd.sendKeys(getData(1, 9));
		shipAdd.sendKeys(getData(1, 15));
		//shipStateTB.sendKeys(getData(1, 0));
		qtyTB.sendKeys(getData(1, 22));
		closeBook();
		commonLib.selectOption(quoteStageDD, 0);
	
     	plusOpp.click();
     	commonLib.switchToChildWindow();
		oppoName.click();
	    driver.switchTo().window(handel);
	   
		prodLookIcon.click();
		commonLib.switchToChildWindow();
		prodName.click();
		driver.switchTo().window(handel);
		saveBtn.click();
		
	 }
public void createQuoteWithStageCreated() throws Throwable {
		
		String handel = driver.getWindowHandle();
		plusBtn.click();
		openSheet(QTN, "Sheet1");
		subTB.sendKeys(getData(2, 0));
		billingAdd.sendKeys(getData(1, 9));
		shipAdd.sendKeys(getData(1, 15));
		//shipStateTB.sendKeys(getData(1, 0));
		qtyTB.sendKeys(getData(1, 22));
		closeBook();
		commonLib.selectOption(quoteStageDD, 0);
	
     	plusOpp.click();
     	commonLib.switchToChildWindow();
		oppoName.click();
	    driver.switchTo().window(handel);
	   
		prodLookIcon.click();
		commonLib.switchToChildWindow();
		prodName.click();
		driver.switchTo().window(handel);
		saveBtn.click();
	 }

public void createQuoteWithStageDelivered() throws Throwable {
	
	String handel = driver.getWindowHandle();
	plusBtn.click();
	openSheet(QTN, "Sheet1");
	subTB.sendKeys(getData(3, 0));
	billingAdd.sendKeys(getData(1, 9));
	shipAdd.sendKeys(getData(1, 15));
	qtyTB.sendKeys(getData(1, 22));
	closeBook();
	commonLib.selectOption(quoteStageDD, 1);
	plusOpp.click();
 	commonLib.switchToChildWindow();
	oppoName.click();
    driver.switchTo().window(handel);
   
	prodLookIcon.click();
	commonLib.switchToChildWindow();
	prodName.click();
	driver.switchTo().window(handel);
	saveBtn.click();
 }


public void createQuoteWithStageReviewed() throws Throwable {
	
	String handel = driver.getWindowHandle();
	plusBtn.click();
	openSheet(QTN, "Sheet1");
	subTB.sendKeys(getData(4, 0));
	billingAdd.sendKeys(getData(1, 9));
	shipAdd.sendKeys(getData(1, 15));
	qtyTB.sendKeys(getData(1, 22));
	closeBook();
	commonLib.selectOption(quoteStageDD, 2);

 	plusOpp.click();
 	commonLib.switchToChildWindow();
	oppoName.click();
    driver.switchTo().window(handel);
   
	prodLookIcon.click();
	commonLib.switchToChildWindow();
	prodName.click();
	driver.switchTo().window(handel);
	saveBtn.click();
 }
}