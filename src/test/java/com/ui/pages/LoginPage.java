package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.QA;
import static com.utility.PropertiesUtility.readProperty;

import org.apache.logging.log4j.Logger;

public final class LoginPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By USERNAME_LOCATOR = By.id("user-name");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//h3[contains(text(),'Epic sadface')]");

    public LoginPage(Browser browserName, boolean isHeadless) {
        super(browserName, isHeadless);
        //using properties
        //goToWebsite(readProperty(QA,"URL"));

        //using json
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public ProductsPage doLoginWith(String username, String password) {
        logger.info("Entering Valid Credentials");
        enterText(USERNAME_LOCATOR, username);
        enterText(PASSWORD_LOCATOR, password);
        logger.info("Clicking On Login button");
        clickOn(LOGIN_BUTTON_LOCATOR);
        return new ProductsPage(getDriver());
    }

    public LoginPage doLoginWithInValidCredentials(String emailaddress, String password) {
        logger.info("Entering Invalid Credentials");
        enterText(USERNAME_LOCATOR, emailaddress);
        enterText(PASSWORD_LOCATOR, password);
        logger.info("Clicking On Login Button");
        clickOn(LOGIN_BUTTON_LOCATOR);
        return new LoginPage(getDriver());
    }

    public String getErrorMessage() {
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }


}
