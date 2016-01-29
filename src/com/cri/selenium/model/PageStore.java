package com.cri.selenium.model;

import org.openqa.selenium.support.PageFactory;

public class PageStore extends BasePage {
	// The getPage method uses the PageFactory to create a page from the class
	//  specified in the parameter.  This PageStore method is what allows the Test to be agnostic
	//  of Selenium entirely.  It also sets up the wait object and ties it to the ready() overloaded in the
	//  concrete Page class.
	public static BasePage getPage(Class<? extends BasePage> clazz){
		BasePage page = PageFactory.initElements(wdResource.driver, clazz);
		wdResource.wait.until(page.ready());
		return page;
	}
}
