package com.cri.selenium.model;

import java.util.Arrays;

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
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{goudaHeading}));
	}
}
