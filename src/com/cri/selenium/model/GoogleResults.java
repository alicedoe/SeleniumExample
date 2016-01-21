package com.cri.selenium.model;

import java.util.Arrays;
import java.util.List;

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
	
	public void goToWikiPage(){
		assert(cheeseWiki.isDisplayed());
	    cheeseWiki.click();
	    wdResource.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mw-wiki-logo"))); 
	}
	
	@Override
	public ExpectedCondition<?> ready() {
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{resultsDiv}));
	}
}
