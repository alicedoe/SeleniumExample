package com.eg.test.automation.selenium.model;

import java.util.Arrays;
import java.util.List;

import com.eg.test.automation.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResults extends BasePage {
	// web elements
	@FindBy(how = How.ID, using = "resultStats")
	WebElement resultsDiv;

	@FindBy(how = How.LINK_TEXT, using = "Cheese - Wikipedia, the free encyclopedia")
	WebElement cheeseWiki;
	
	public void verifyResults(){
	    assert(resultsDiv.isDisplayed());
	    System.out.println("We fround: " + resultsDiv.getText());
	    // And now list the suggestions
	    List<WebElement> allSuggestions = wdResource.driver.findElements(By.className("r"));
	    for (WebElement suggestion : allSuggestions) {
	    	System.out.println(suggestion.getText());
	    }
	}
	
	public CheeseWiki goToWikiPage(){
		assert(cheeseWiki.isDisplayed());
	    cheeseWiki.click();
		CheeseWiki cheesePage = getInstance(CheeseWiki.class);
	    wdResource.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mw-wiki-logo")));
		return cheesePage;
	}
	
	@Override
	public ExpectedCondition<?> ready() {
		// calling the super class ready() first allow you to setup the parent
		// and local window handles and switch to the correct window prior to
		// checking for your ready condition.
		super.ready();

		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{resultsDiv}));
	}
}
