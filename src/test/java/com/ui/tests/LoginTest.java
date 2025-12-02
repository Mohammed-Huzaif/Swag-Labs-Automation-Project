package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    @Test(description = "Verifies valid login", groups = {"e2e", "smoke", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProviderJson",
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void loginTest(User user) {

        logger.info("Started Login Test");
        assertEquals(loginPage.doLoginWith(user.getUsername(), user.getPassword())
                .getProductsHeading(), "Products");
        logger.info("Completed Login Test");

    }


}
