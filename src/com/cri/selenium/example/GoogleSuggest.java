package com.cri.selenium.example;

import org.junit.Test;
import com.cri.selenium.model.*;

public class GoogleSuggest {
	@Test
	public void cheeseTest() throws Exception {
		GoogleSearch searchPage = (GoogleSearch)PageStore.getPage(GoogleSearch.class);
	    //searchPage.searchForCheese();
		searchPage.searchBox.sendKeys("Cheese");
		searchPage.btnSubmit.click();

		GoogleResults resultsPage = (GoogleResults)PageStore.getPage(GoogleResults.class);
	    resultsPage.verifyResults();
	    resultsPage.goToWikiPage();   
	        
	    CheeseWiki cheesePage = (CheeseWiki)PageStore.getPage(CheeseWiki.class);
	    cheesePage.goToGoudaPage();
	    
	    GoudaWiki goudaPage = (GoudaWiki)PageStore.getPage(GoudaWiki.class);
	    goudaPage.verifyGoudaPage();
	    
	    PageStore.quit();
	} // end cheeseTest()
}