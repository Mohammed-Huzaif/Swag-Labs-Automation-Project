package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    protected LoginPage loginPage;

    @Parameters({"browser", "isHeadless"})
    @BeforeMethod(description = "Load the Login page of the website")
    public void setup(
            @Optional("chrome") String browser,
            @Optional("false") boolean isHeadless){

        logger. info("Loading Login Page");
        loginPage = new LoginPage(Browser.valueOf(browser.toUpperCase()),isHeadless);

    }

    public BrowserUtility getInstance(){
        return loginPage;
    }
}
