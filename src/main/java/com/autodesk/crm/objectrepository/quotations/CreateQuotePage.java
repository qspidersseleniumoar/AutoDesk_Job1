package com.autodesk.crm.objectrepository.quotations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.autodesk.crm.commonlib.BaseClass;
import com.autodesk.crm.commonlib.CommonLibrary;
import static com.autodesk.crm.commonlib.ExcelLib.*;

/**
 * 
 * @author Rohan
 *
 */
public class CreateQuotePage extends BaseClass {
	private WebDriver driver;
	private CommonLibrary commonLib;

	@FindBy(xpath = "//img[contains(@src,'btnL3Add.gif')]")
	private WebElement plusBtn;
	@FindBy(name = "subject")
	private WebElement subTB;
	@FindBy(xpath = "(//img[@title='Select'])[3]")
	private WebElement orgLookIcon;
	@FindBy(linkText = "HP")
	private WebElement orgName;
	@FindBy(name = "carrier")
	private WebElement carrierDD;
	@FindBy(name = "bill_street")
	private WebElement billingAdd;
	@FindBy(name = "ship_street")
	private WebElement shipAdd;
	@FindBy(id = "searchIcon1")
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
	/**
	 * @author Vinita
	 */
	private WebElement plusOpp;
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
	 * @author pradeep
	 */

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement OrgName;
	@FindBy(xpath = "//img[@id='searchIcon1']")
	private WebElement products;
	@FindBy(id = "dtlview_Subject")
	private WebElement quoteSubject;
	@FindBy(xpath = "//span[@id='dtlview_Quote Stage']/font")
	private WebElement quoteStage;

	public void selectORG(String companyName) {
		driver.findElement(By.xpath("//a[text()='" + companyName + "']")).click();
	}

	public void selectProduct(String productName) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
	}

	public void selectContact(String Contact) {
		driver.findElement(By.xpath("//a[text()='" + Contact + "']")).click();
	}

	/**
	 * @author Pradeep Sharma method is use for scolling in this method we need to
	 *         provide element
	 */
	public void scrollIntoView(WebElement ele) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	public CreateQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		commonLib = new CommonLibrary(driver);
	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void CreateQuoteWithStageAccepted() throws Throwable {
		plusBtn.click();

		openSheet(QTN, "Sheet1");
		// openSheet(filePath, sheetName)
		String wh = driver.getWindowHandle();
		subTB.sendKeys(getData(1, 1));
		commonLib.selectOption(quoteStageDD, getData(1, 3));
		orgLookIcon.click();
		commonLib.switchToChildWindow();
		selectORG(getData(1, 2));
		commonLib.acceptAlert();
		driver.switchTo().window(wh);
		products.click();
		commonLib.switchToChildWindow();
		selectProduct(getData(1, 4));
		driver.switchTo().window(wh);
		qtyTB.sendKeys(getData(1, 5));
		saveBtn.click();
		closeBook();
	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void verifyCreateQuoteWithStageAccepted() throws Throwable {
		String actual = quoteSubject.getText();
		String expected = getData(1, 1);
		String actual1 = quoteStage.getText();
		String expected1 = getData(1, 3);
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual1, expected1);
		closeBook();

	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void CreateQuoteWithStageRejected() throws Throwable {
		plusBtn.click();

		openSheet(QTN, "Sheet1");
		String wh = driver.getWindowHandle();
		subTB.sendKeys(getData(2, 1));
		commonLib.selectOption(quoteStageDD, getData(2, 3));
		// commonLib.selectOption(quoteStageDD, 5);
		orgLookIcon.click();
		commonLib.switchToChildWindow();
		selectORG(getData(2, 2));
		commonLib.acceptAlert();
		driver.switchTo().window(wh);
		products.click();
		commonLib.switchToChildWindow();
		selectProduct(getData(2, 4));
		driver.switchTo().window(wh);
		qtyTB.sendKeys(getData(2, 5));
		saveBtn.click();
		closeBook();
	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void verifyCreateQuoteWithStageRejected() throws Throwable {
		String actual = quoteSubject.getText();
		String expected = getData(2, 1);
		String actual1 = quoteStage.getText();
		String expected1 = getData(2, 3);
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual1, expected1);
		closeBook();

	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void CreateQuoteWithContact() throws Throwable {
		plusBtn.click();

		openSheet(QTN, "Sheet1");
		String wh = driver.getWindowHandle();
		subTB.sendKeys(getData(3, 1));
		orgLookIcon.click();
		commonLib.switchToChildWindow();
		selectORG(getData(3, 2));
		commonLib.acceptAlert();
		driver.switchTo().window(wh);
		contactNameLookIcon.click();
		commonLib.switchToChildWindow();
		selectContact(getData(3, 3));
		commonLib.acceptAlert();
		driver.switchTo().window(wh);
		qtyTB.sendKeys(getData(3, 5));
		products.click();
		commonLib.switchToChildWindow();
		selectProduct(getData(3, 4));
		// commonLib.acceptAlert();
		// driver.switchTo().window(wh);
		saveBtn.click();
		closeBook();

	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void CreateQuoteWithOrganisation() throws Throwable {
		plusBtn.click();
		openSheet(QTN, "Sheet1");
		String wh = driver.getWindowHandle();
		subTB.sendKeys(getData(4, 1));
		orgLookIcon.click();
		commonLib.switchToChildWindow();
		selectORG(getData(4, 2));
		commonLib.acceptAlert();
		driver.switchTo().window(wh);
		products.click();
		commonLib.switchToChildWindow();
		selectProduct(getData(4, 3));
		driver.switchTo().window(wh);
		qtyTB.sendKeys(getData(4, 4));
		saveBtn.click();
		closeBook();
	}

	/**
	 * 
	 * @author Pradeep Sharma
	 */
	public void verifyCreateQuoteWithOrganisation() throws Throwable {
		String actual = OrgName.getText();
		String expected = getData(4, 2);
		Assert.assertEquals(actual, expected);
		String actual1 = quoteSubject.getText();
		String expected1 = getData(4, 1);
		Assert.assertEquals(actual1, expected1);

	}

}
