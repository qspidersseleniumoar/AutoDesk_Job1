package com.autodesk.crm.objectrepository.organizations;

import static com.autodesk.crm.commonlib.ExcelLib.closeBook;
import static com.autodesk.crm.commonlib.ExcelLib.getData;
import static com.autodesk.crm.commonlib.ExcelLib.openSheet;
import static com.autodesk.crm.commonlib.ExcelLib.setData;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.commonlib.CommonLibrary;
import com.autodesk.crm.commonlib.ExcelLib;
import com.autodesk.crm.commonlib.IFilePaths;

public class CreatingNewOrganizationPage implements IFilePaths {
	 String orgname;
	 String etxt1;
	 String etxt2;
	 String invalidexpect;
	/**
	 * Initiate CreatingNewOrganizationPage
	 * @param driver
	 */
	private CommonLibrary common;
	private WebDriver driver;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
		
	}
	
	
	
//	public WebDriver getDriver() {
//		return driver;
//	}
	
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtn;
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']") private WebElement cancelBtn;
	@FindBy(xpath = "//input[@name='accountname']") private WebElement orgNameEdt;
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement successtxt1;
	@FindBy(xpath="//span[@class='small']") private WebElement successtxt2;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	
	public void createOrgWithName(String sheetName, int rowNum, int colNum) throws Throwable { 
		openSheet(ORG, sheetName); 
		this.orgname = getData(rowNum, colNum);
		Thread.sleep(3000);
		
		//System.out.println(data);
		
		closeBook();
	}
	
	public void enterorg()
	{  
	    Reporter.log("Entering the Organization");
		orgNameEdt.sendKeys(this.orgname);
		
		
	}
	
	public void clicksavebtn()
	{
		saveBtn.click();
	}
	
	public void successmsgvalidation() throws Throwable
	{
		Thread.sleep(2000);
		Reporter.log("Entered the success validation method",true);
		String actxt1=successtxt1.getText().trim();
		Reporter.log(actxt1,true);
		String actxt2=successtxt2.getText().trim();
		Reporter.log(actxt2,true);
		this.etxt1 = getData(1,0).trim();
		Reporter.log(etxt1,true);
		this.etxt2 = getData(1,1).trim();
		Reporter.log(etxt2,true);
		if((actxt1.equals(etxt1)) && (actxt2.equals(etxt2)))
				{
			Reporter.log("The message successfully validated",true);
			Assert.assertEquals(true, true);
				}
		else
		{
			Reporter.log("Chezck fails",true);
		   Assert.assertEquals(false, true);
				}
		
		
		
		
		
	}
	
	public void validaateDuplicateorgmsg() throws Throwable
	{

    String edmsg=getData(2,0).trim();
    String admsg=common.acceptAlert();
    Reporter.log(admsg,true);
	Reporter.log(admsg,true);
	Assert.assertEquals(edmsg, admsg);

			
		
	}
	
	
	public void Invalidorgmsg() throws Throwable
	{
	Reporter.log("Hi");

			
		
	}
	}

