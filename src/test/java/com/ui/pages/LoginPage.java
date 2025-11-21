package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.constants.Env.QA;
import static com.utility.PropertiesUtility.readProperty;

public final class LoginPage extends BrowserUtility {

    private static final By USERNAME_LOCATOR = By.id("user-name");
    private static final By PASSWORD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");

    public LoginPage(Browser browserName, boolean isHeadless) {
        super(browserName,isHeadless);
        //using properties
        //goToWebsite(readProperty(QA,"URL"));

        //usingjson
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }


    public ProductsPage doLoginWith(String username, String password){
       enterText(USERNAME_LOCATOR,"standard_user");
       enterText(PASSWORD_LOCATOR,"secret_sauce");
       clickOn(LOGIN_BUTTON_LOCATOR);
       return new ProductsPage(getDriver());
    }


}
