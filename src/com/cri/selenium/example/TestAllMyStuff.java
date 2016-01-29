package com.cri.selenium.example;

import org.junit.*;
import com.cri.selenium.model.*;

public class TestAllMyStuff {
	@Test
	public void cheeseTest() throws Exception {
		/* Use the store to get our first page.  Encapsulated in this call is the creation of our WebDriver Resource
			which gives us our driver and wait objects.  We will also use the Browser Factory to select the appropriate
			browser driver object.
		*/
		GoogleSearch searchPage = (GoogleSearch)PageStore.getPage(GoogleSearch.class);

		// calling the searchForCheese method will preform the search and return the results page.
	    GoogleResults resultsPage = searchPage.searchForCheese();

		// once we have our results page we can call methods on the page object and navigate off of it to another page object.
	    resultsPage.verifyResults();
		CheeseWiki cheesePage = resultsPage.goToWikiPage();

		GoudaWiki goudaPage = cheesePage.goToGoudaPage();
	    goudaPage.verifyGoudaPage();
	} // end cheeseTest()

	@Test
	public void jQueryUI() throws Exception {
		jQueryUiHome jQueryPage = (jQueryUiHome) PageStore.getPage(jQueryUiHome.class);
		jQueryPage.gotoPage();
		jQueryPage.verifyPage();
		jQueryPage.demosLink.click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		// Code executed after each test 
		// quit is an inherited method on Base Page class.  You can call quit on any page or the Store itself.
		PageStore.quit();
	}

}