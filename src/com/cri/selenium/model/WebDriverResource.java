package com.cri.selenium.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverResource {
	private static WebDriverResource instance = null;
	public WebDriver driver = BrowserFactory.getDriver("firefox");
	public WebDriverWait wait = new WebDriverWait(driver, 20);

	// Exists only to defeat instantiation.
	protected WebDriverResource() {
		driver.get("http://www.google.com/webhp?complete=1&hl=en");
	}
		
	public static WebDriverResource getInstance() {
		if(instance == null){
			instance = new WebDriverResource();
		}
		return instance;
	} // end getInstance()
}  //  end class
