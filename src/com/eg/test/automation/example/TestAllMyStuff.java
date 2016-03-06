package com.eg.test.automation.example;

import com.eg.test.automation.selenium.BasePage;
import com.eg.test.automation.selenium.model.*;
import org.junit.AfterClass;
import org.junit.Test;

public class TestAllMyStuff {

	@Test
	public void cheeseTest() throws Exception {
		/*  Use the BasePage getInstance() to get a reference to your first model.  Encapsulated in this call is the
		    creation of our WebDriver Resource which gives us our driver and wait objects.  We will also use the
		    Browser Factory to select the appropriate browser driver object.
		*/
		GoogleSearch searchPage = BasePage.getInstance(GoogleSearch.class);

	    GoogleResults resultsPage = searchPage.searchForCheese();

		// once we have our results page we can call methods on the page object and navigate off of it to another page object.
	    resultsPage.verifyResults();
		CheeseWiki cheesePage = resultsPage.goToWikiPage();

		GoudaWiki goudaPage = cheesePage.goToGoudaPage();
	    goudaPage.verifyGoudaPage();
	} // end cheeseTest()

	//@Test
	public void jQueryUI() throws Exception {
		jQueryUiHome jQueryPage = BasePage.getInstance(jQueryUiHome.class);
		jQueryPage.gotoPage();
		jQueryPage.verifyPage();
		jQueryPage.demosLink.click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		BasePage.quit();
	}

}