package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {



    protected LoginPage loginPage;

    @Parameters({"browser", "isHeadless"})
    @BeforeMethod(description = "Load the Login page of the website")
    public void setup(
            @Optional("chrome") String browser,
            @Optional("true") boolean isHeadless){
        loginPage = new LoginPage(Browser.valueOf(browser.toUpperCase()),isHeadless);

    }

    public BrowserUtility getInstance(){
        return loginPage;
    }
}
