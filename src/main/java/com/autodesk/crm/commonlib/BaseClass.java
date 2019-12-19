package com.autodesk.crm.commonlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.autodesk.crm.objectrepository.common.HomePage;
import com.autodesk.crm.objectrepository.common.LoginPage;

/**
 * 
 * @author Deepak
 *
 */
@Listeners(com.autodesk.crm.commonlib.Listener.class)
public class BaseClass implements IAutoConstants, IFilePaths {
	/* create an object for excel library */
	public WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public EventFiringWebDriver edr;

	/**
	 * Initializing reports
	 * 
	 * @throws Throwable
	 */
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
		ExtentReportLib.extentInit();
	}

	/**
	 * Launch the selected browser
	 * 
	 * @throws Throwable
	 */
	@BeforeTest
	public void configBeforeTest() throws Throwable {
		/* Get the url and type of browser from runtime parameters */
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");

		if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(url);
		edr = new EventFiringWebDriver(driver);

		loginToApp();
	}

	/**
	 * Login to the application
	 * 
	 * @throws Throwable
	 */
	public void loginToApp() throws Throwable {
		loginPage = new LoginPage(driver);

		/* get username and password from runtime parameters */
		String username = System.getProperty("username");
		String password = System.getProperty("password");

		homePage = loginPage.login(username, password);
	}

	/**
	 * Logout of the application Close the browser
	 */
	@AfterTest
	public void configAfterTest() {
		homePage.signOut();
		driver.quit();
	}

	/**
	 * 
	 * Appends the report HTML file with all the test results and closes the
	 * underlying stream Kills driver executable instances
	 * 
	 * @throws Throwable
	 */
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		Runtime.getRuntime().exec("taskkill -im chromedriver.exe /f");
		Runtime.getRuntime().exec("taskkill -im geckodriver.exe /f");
	}
}