package com.cri.selenium.model;

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

	// Exists to defeat instantiation and set the parameters.
	//  http://www.google.com/webhp?complete=1&hl=en
	protected WebDriverResource() {
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

    //  This method allow us to get a new WebDriverResource for anohter window.
    //  It will use the same config data, but will have a handle to a different webdriver then
    //  the primary WebDriverResource object.  Note:  You will have to navigate this webdriver from scratch.
	//  Tabs launch from the Primary WebDriver will be manged, switched to and from within the Primary WebDriver.
    public static WebDriverResource newWindow(){
        WebDriverResource wdr = new WebDriverResource();
        return wdr;
    }
}  //  end class
