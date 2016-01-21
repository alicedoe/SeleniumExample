package com.cri.selenium.model;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheeseWiki extends BasePage {
	// web elements
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Gouda')]")
	WebElement goudaLink;
	
	public void goToGoudaPage(){
		assert(goudaLink.isDisplayed());
	    goudaLink.click();
	}
	
	@Override
	public ExpectedCondition<?> ready() {
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{goudaLink}));
	}
	
}
