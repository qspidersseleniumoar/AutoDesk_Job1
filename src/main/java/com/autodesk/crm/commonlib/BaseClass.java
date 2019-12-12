package com.autodesk.crm.commonlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.autodesk.crm.objectrepository.HomePage;
import com.autodesk.crm.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Deepak
 *
 */
public class BaseClass  {
	/* create an object for excel library */
	public ExcelLib eLib = new ExcelLib();
	
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;

	
	/**
	 * Initializing reports
	 */
	@BeforeSuite
	public void configBeforeSuite() {
		ExtentReportLib.extentInit();
	}

	/**
	 * Launch the selected browser
	 * @throws Throwable
	 * @throws InvalidFormatException
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
	 * @throws IOException
	 */
	@BeforeClass
	public void configBeforeClass() throws Throwable, InvalidFormatException, InvalidFormatException, IOException {
		/* get the url and type of browser properties from maven parameters */
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	/**
	 * Login to the application
	 * 
	 * @throws Throwable
	 */
	@BeforeMethod
	public void configBeforeMethod() throws Throwable {
		loginPage = new LoginPage(driver);

		/* get username and password from runtime parameters */
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		homePage = loginPage.login(username, password);
	}

	/**
	 * Logout of the application
	 */
	@AfterMethod
	public void configAfterMethod() {
		homePage.signOut();
	}

	/**
	 * Close the browser
	 */
	@AfterClass
	public void configafterClass() {
		driver.quit();
	}

	/**
	 * Appends the report HTML file with all the test results and 
	 * closes the underlying stream
	 */
	@AfterSuite
	public void configAfterSuite() {
		
	}
}