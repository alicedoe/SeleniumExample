package com.eg.test.automation.selenium.model;

import java.util.Arrays;

import com.eg.test.automation.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoudaWiki extends BasePage {
	// web elements
	@FindBy(how = How.ID, using = "firstHeading")
	WebElement goudaHeading;

	public void verifyGoudaPage() {
		assert (goudaHeading.getText().equals("Gouda cheese"));
	}
	
	@Override
	public ExpectedCondition<?> ready() {
		// calling the super class ready() first allow you to setup the parent
		// and local window handles and switch to the correct window prior to
		// checking for your ready condition.
		super.ready();

		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{goudaHeading}));
	}
}
