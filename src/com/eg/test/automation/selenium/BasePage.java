package com.eg.test.automation.selenium;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
	public static WebDriverResource wdResource = WebDriverResource.getInstance();
	// The parentWindowHandle and localWindowHandle are static strings representing the
	// handle of the local page window or tab being used by this page and its parent.
	//  Any test that only uses one tab or browser window will have the same string in
	// both variables, but if you use multiple tabs you will use these attribute to switch
	// the driver to this window.  The example is setup with the most common pattern being
	// that you launch one window from another then go back to the parent.  If you are doing
	// something more complected where you have three levels and you are constantly going
	// back and forth you will need to do something more explicit to your situations.
	static String parentWindowHandle;
	static String localWindowHandle;

	static WebDriverResource getNewWindow(){
		parentWindowHandle =  wdResource.driver.getWindowHandle();
		WebDriverResource newWdResource = WebDriverResource.newWindow();
		localWindowHandle =  newWdResource.driver.getWindowHandle();
		return newWdResource;
	}

	// The getInstance method uses the PageFactory to create a page from the class
	//  specified in the parameter.  This BasePage method is what allows the Test to be agnostic
	//  of Selenium entirely.  It also sets up the wait object and ties it to the ready() overloaded in the
	//  concrete Page class.
	public static <C extends BasePage> C getInstance(Class<C> clazz){
		C page = PageFactory.initElements(wdResource.driver, clazz);
		wdResource.wait.until(page.ready());
		return page;
	}
	
	public static void quit(){
		wdResource.driver.quit();
	}
	
	public ExpectedCondition<?> ready(){
		// set parent and local Window Handles then switch to local handle
		parentWindowHandle = wdResource.driver.getWindowHandle();
		List<String> handlesList = new ArrayList<String>(wdResource.driver.getWindowHandles());
		localWindowHandle = handlesList.get(handlesList.size() - 1);
		wdResource.driver.switchTo().window(localWindowHandle);

		// this is the default case with no wait so return null
		return null;
	}
}
