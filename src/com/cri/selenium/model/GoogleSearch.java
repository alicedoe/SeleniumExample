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
	
	public void searchForCheese(){
	    searchBox.sendKeys("Cheese");
	    btnSubmit.click();
	}

	@Override
	public ExpectedCondition<?> ready() {
		return ExpectedConditions.visibilityOfAllElements(Arrays.asList(new WebElement[]{searchBox}));
	}

}
