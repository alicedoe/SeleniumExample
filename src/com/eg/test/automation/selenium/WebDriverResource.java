package com.eg.test.automation.selenium;

import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import org.json.simple.*;

public class WebDriverResource {
	// create our base webdriver and setup its wait object
	private static WebDriverResource instance = null;
	public WebDriver driver;
	public WebDriverWait wait;

	//  Exists to defeat instantiation and set the parameters.  We will pull the browser name, wait timeout,
	//  and base url from the json file then setup the WebDriverResource driver and wait variables.
	private WebDriverResource() {
		//  lets get the browser info from the JSON config file.
        String browserName= "";
        String baseURL = "";
        int waitTimeOut = 0;
		try
		{
			JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader("./src/config.json"));
            JSONObject pageInfo = (JSONObject)jsonObject.get("pageInfo");
            browserName = pageInfo.get("browserName").toString();
            baseURL = pageInfo.get("baseURL").toString();
            waitTimeOut = Integer.parseInt(pageInfo.get("waitTimeOut").toString());
		}
		catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

		driver = BrowserFactory.getDriver(browserName);
		wait = new WebDriverWait(driver, waitTimeOut);
		driver.get(baseURL);
	}

	//  This is our singleton insuring we only have one primary WebDriverResource for all pages.
	//  This can be overwritten in the individual page object if a given page is opened in a new tab
	//  or new browser window.
	public static WebDriverResource getInstance() {
		if(instance == null){
			instance = new WebDriverResource();
		}
		return instance;
	} // end getInstance()

}  //  end class
