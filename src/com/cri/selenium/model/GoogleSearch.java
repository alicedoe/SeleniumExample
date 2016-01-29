package com.cri.selenium.model;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearch extends BasePage {
	// web elements
	@FindBy(how = How.NAME, using = "q")
	public WebElement searchBox;
	
	@FindBy(how = How.NAME, using = "btnG")
	public WebElement btnSubmit;
	
	public GoogleResults searchForCheese(){
	    searchBox.sendKeys("Cheese");
	    btnSubmit.click();
		GoogleResults resultsPage = (GoogleResults)PageStore.getPage(GoogleResults.class);
		return resultsPage;
	}

	@Override
	public ExpectedCondition<?> ready() {
		// calling the super class ready() first allow you to setup the parent
		// and local window handles and switch to the correct window prior to
		// checking for your ready condition.
		super.ready();
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{searchBox}));
	}

}
