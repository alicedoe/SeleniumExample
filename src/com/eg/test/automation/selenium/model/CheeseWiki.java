package com.eg.test.automation.selenium.model;

import java.util.Arrays;

import com.eg.test.automation.selenium.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheeseWiki extends BasePage {
	// web elements
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Gouda')]")
	WebElement goudaLink;
	
	public GoudaWiki goToGoudaPage(){
		assert(goudaLink.isDisplayed());
		goudaLink.sendKeys(Keys.SHIFT, Keys.ENTER);
		GoudaWiki goudaPage = getInstance(GoudaWiki.class);

		return goudaPage;
	}
	
	@Override
	public ExpectedCondition<?> ready() {
		// calling the super class ready() first allow you to setup the parent
		// and local window handles and switch to the correct window prior to
		// checking for your ready condition.
		super.ready();
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{goudaLink}));
	}
	
}
