package com.cri.selenium.model;

import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class BasePage {
	static WebDriverResource wdResource = WebDriverResource.getInstance();
	
	public static void quit(){
		wdResource.driver.quit();
	}
	
	public ExpectedCondition<?> ready(){return null;}
}
