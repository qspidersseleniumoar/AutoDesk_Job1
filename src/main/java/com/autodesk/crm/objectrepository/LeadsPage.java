package com.autodesk.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//img[contains(@src,'btnL3Add.gif')]") private WebElement plusBtn;
	@FindBy(xpath="//input[contains(@title,'Cancel')]") private WebElement cancelBtn;
	
	/**
	 * Initiate the leads page
	 * @param driver
	 */
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * Create a lead using the plus button
	 */
	public void createLeadUsingPlus() {
		plusBtn.click();
		cancelBtn.click();
	}
	
}
