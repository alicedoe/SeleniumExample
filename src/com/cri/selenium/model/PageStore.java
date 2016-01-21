package com.cri.selenium.model;

import org.openqa.selenium.support.PageFactory;

public class PageStore extends BasePage {
	public static BasePage getPage(Class<? extends BasePage> clazz){
		BasePage page = PageFactory.initElements(wdResource.driver, clazz);
		wdResource.wait.until(page.ready());
		return page;
	}
}
