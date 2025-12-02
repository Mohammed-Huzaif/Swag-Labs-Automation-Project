package com.ui.tests;

import com.utility.LoggerUtility;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.*;

@Listeners({com.ui.listeners.TestListeners.class})
public class InvalidLoginTest extends TestBase {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    public static final String INVALID_USERNAME = "abc@gmail.com";
    public static final String INVALID_PASSWORD = "abc@123";

    @Test(description = "Verifies Invalid login", groups = {"e2e", "smoke", "sanity"},
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void invalidLoginTest() {

        logger.info("Started InValid Login Test");
        assertTrue(loginPage.doLoginWithInValidCredentials(INVALID_USERNAME, INVALID_PASSWORD).getErrorMessage()
                .contains("Epic sadface"));
        logger.info("Completed InValid Login Test");

    }
}
