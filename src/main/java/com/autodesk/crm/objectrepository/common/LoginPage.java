package com.autodesk.crm.objectrepository.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepak
 *
 */
public class LoginPage {
	
	@FindBy(name = "user_name") private WebElement usernameTxt;
	@FindBy(name = "user_password")	private WebElement passwordTxt;
	@FindBy(id = "submitButton") private WebElement loginBtn;
	
	private WebDriver driver;

	/**
	 * Initiate the login page
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * Get the WebElement Username textbox
	 * @return
	 */
	public WebElement getUsernameEdit() {
		return usernameTxt;
	}

	/**
	 * Get the WebElement Password TextBox
	 * @return
	 */
	public WebElement getPasswordEdt() {
		return passwordTxt;
	}

	/**
	 * Get the WebElement Login button
	 * @return
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * Login to the application with specified username and password
	 * @param username
	 * @param password
	 * @return 
	 */
	public HomePage login(String username, String password) {
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		loginBtn.click();
		return new HomePage(driver);

	}
}
