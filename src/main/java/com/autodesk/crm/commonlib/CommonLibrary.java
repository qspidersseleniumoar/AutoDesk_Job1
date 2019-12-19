package com.autodesk.crm.commonlib;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * 
 * @author Deepak
 *
 */
public class CommonLibrary implements IFilePaths, IAutoConstants{

	private WebDriver driver;
	private JavascriptExecutor jse;
	private String alertMessage;
	private FluentWait<WebDriver> fwait;

	public CommonLibrary(WebDriver driver) {
		this.driver=driver;
		this.jse = (JavascriptExecutor)driver;
	}

	/**
	 * Execute the javascript
	 * @return One of Boolean, Long, Double, String, List, Map or WebElement. Or null. 
	 */
	public Object runScript(String script) {
		return jse.executeScript(script);
	}

	/**
	 * used to wait for page to load before element available in DOM
	 */
	public void waitForPageToLoad(){
		fwait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(FPP))
				.withTimeout(Duration.ofSeconds(FTO))
				.ignoring(NoSuchElementException.class);

		fwait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver input) {
				String state = (String) runScript("return document.readyState");
				if(state.equals("complete")) {
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * Wait for element to be available on GUI
	 * @param element
	 */
	public void waitForElemetToBePresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for element to be displayed on GUI
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElemnetToAppear(WebElement element) throws InterruptedException {
		int timeCount =0;
		while(timeCount<20) {
			try {
				element.isDisplayed();
				break;
			}catch (Exception e) {
				Thread.sleep(FPP);
				timeCount++;
			}
		}
	}

	/**
	 * Wait for element to be displayed on GUI & click
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int timeCount =0;
		while(timeCount<20) {
			try {
				element.click();
				break;
			}catch (Exception e) {
				Thread.sleep(FPP);
				timeCount++;
			}
		}
	}

	/**
	 * Select the Option based on text in GUI
	 * @param element
	 * @param data to be selected
	 */
	public void selectOption(WebElement element, String data){
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}

	/**
	 * Select the option based on index
	 * @param element
	 * @param index of the option
	 */
	public void selectOption(WebElement element, int index){
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * Select the value from the dynamic select dropDown
	 * @param element
	 * @param data
	 * @return boolean if the option was selected
	 */
	public boolean selectDynamicOption(WebElement element, String data){
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for(WebElement option:options) {
			if(option.getText().equals(data)) {
				sel.selectByVisibleText(data);
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Switch to alert popup and click OK
	 * @return String displayed in alert message
	 */
	public String acceptAlert() {
		new WebDriverWait(driver, ETO).until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		alertMessage = alt.getText();
		alt.accept();
		return alertMessage;
	}

	/**
	 *  Switch to alert popup and click cancel
	 * @return String displayed in alert message
	 */
	public String dismissAlert() {
		new WebDriverWait(driver, ETO).until(ExpectedConditions.alertIsPresent());
		Alert alt = driver.switchTo().alert();
		alertMessage = alt.getText();
		alt.dismiss();
		return alertMessage;
	}

	private String parentId;
	private String childId; 
	private Set<String> windows;
	
	/**
	 * Obtains the parent and the child window handles
	 * @return Set of window handles
	 */
	private Set<String> switchWindow() {
		windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		parentId = window.next();
		childId = window.next();
		return windows;
	}
	
	/**
	 * Switches to the child window
	 */
	public void switchToChildWindow() {
		switchWindow();
		driver.switchTo().window(childId);
	}
	
	/**
	 * Switch to child window that contains the specified Title
	 * @param title of the window to be switched to
	 */
	public void switchToChildWindow(String title) {
		switchWindow();
		windows.remove(parentId);
		for(String window:windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	/**
	 * Switch back to new parent Window
	 */
	public void switchToParentWindow() {
		driver.switchTo().window(parentId);
	}

}
