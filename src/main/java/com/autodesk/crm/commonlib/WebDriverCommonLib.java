package com.autodesk.crm.commonlib;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * 
 * @author Deepak
 *
 */
public class WebDriverCommonLib extends BaseClass{

	/**
	 * used to wait for page to load before element available in DOM
	 */
	public void waitForPageToLoad(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * wait for Element to be available in GUI
	 * @param elemnet
	 */
	public void waitForElemetPresent(WebElement elemnet){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(elemnet));
	}
	/**
	 * custom wait : wait for element to be displayed in GUI
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElemnetToBeAppear(WebElement element) throws InterruptedException {
		int timeCount =0;
		while(timeCount<20) {
			try {
				element.isDisplayed();
				break;
			}catch (Exception e) {
				Thread.sleep(1000);
				timeCount++;
			}
		}
	}

	/**
	 * wait for the element in GUI & click if element is availble in GUI
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
				Thread.sleep(1000);
				timeCount++;
			}
		}
	}
	/**
	 * used the select the Option based on text in GUI
	 * @param selwb
	 * @param data
	 */
	public void select(WebElement selwb, String data){
		Select sel = new Select(selwb);
		sel.selectByVisibleText(data);
	}
	/**
	 * used the select the option based on index
	 * @param selwb
	 * @param data
	 */
	public void select(WebElement selwb, int index){
		Select sel = new Select(selwb);
		sel.selectByIndex(index);
	}
	/**
	 * select the value from the dynamic Select dropDown
	 * @param selwb
	 * @param data
	 * @return
	 */
	public boolean selectDynamicOption(WebElement selwb, String data){
		boolean flag = false;
		Select sel = new Select(selwb);
		List<WebElement> lst = sel.getOptions();
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getText().equals(data)) {
				sel.selectByVisibleText(data);
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("not avialble");
		}
		return flag;
	}
	/**
	 *  Switch to Alert PopUp & click on OK
	 */
	public void alertAccept() {
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

	/**
	 *  Switch to Alert PopUp & click on Cancel
	 */
	public void alertdismiss() {

		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());

		alt.dismiss();
	}

	public static String parentId;
	public static String childId; 
	/**
	 * Switch to new child Window
	 */
	public void switchToChildWindow() {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentId = it.next();
		childId = it.next();
		driver.switchTo().window(childId);
	}

	/**
	 * Switch back to new parent Window
	 */
	public void switchToParentWindow() {

		driver.switchTo().window(parentId);
	}

	/**
	 * swicth to new Window based on title
	 * @param pageTitle
	 */
	public void switchToWindowBasedOnTitle(String pageTitle) {
		String windowID = null;
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		for(int i=0; i<set.size();i++) {
			windowID = it.next();
			driver.switchTo().window(windowID);

			if(windowID.contains(pageTitle)) {
				System.out.println("switched to "+pageTitle + "window");
				break;
			}
		}
	}




}
