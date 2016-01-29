package com.eg.test.automation.selenium.model;

import java.util.Arrays;

import com.eg.test.automation.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class jQueryUiHome extends BasePage {
    // web elements
    @FindBy(how = How.ID_OR_NAME, using = "global-nav")
    WebElement headerNavBar;

    @FindBy(how = How.CLASS_NAME, using = "footer-site-links")
    WebElement footerLinksUL;

    @FindBy(how = How.LINK_TEXT, using = "Demos")
    public WebElement demosLink;

    public void gotoPage(){wdResource.driver.get("http://jqueryui.com/");}
    public void verifyPage() {
        assert(demosLink.isDisplayed());
    }


    @Override
    public ExpectedCondition<?> ready() {
        // calling the super class ready() first allow you to setup the parent
        // and local window handles and switch to the correct window prior to
        // checking for your ready condition.
        super.ready();
        // given that this script will use the existing browser window we will
        // need to nav to the page we want.
        this.gotoPage();
        return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{headerNavBar, footerLinksUL}));
    }

}
