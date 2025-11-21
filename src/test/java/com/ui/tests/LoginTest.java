package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase {


    @Test(description = "Verifies valid login", groups = {"e2e", "smoke", "sanity"},
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProviderJson",
    retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
   public void loginTest(User user){
        //LoginPage loginPage = new LoginPage(Browser.CHROME);

        assertEquals(loginPage.doLoginWith(user.getUsername(), user.getPassword())
                .getProductsHeading(), "Products");

   }


}
