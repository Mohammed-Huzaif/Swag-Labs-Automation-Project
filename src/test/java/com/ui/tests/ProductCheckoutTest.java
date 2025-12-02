package com.ui.tests;

import com.ui.pages.ProductsPage;
import com.ui.pojo.CustomerInformation;
import com.utility.FakeInformationUtility;
import com.utility.LoggerUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.*;

@Listeners({com.ui.listeners.TestListeners.class})
public class ProductCheckoutTest extends TestBase {

    private ProductsPage productsPage;
    private CustomerInformation customerInformation;
    Logger logger = LoggerUtility.getLogger(this.getClass());


    @BeforeMethod(description = "User Logs into application")
    public void setUp() {
        productsPage = loginPage.doLoginWith("standard_user", "secret_sauce");
        customerInformation = FakeInformationUtility.getFakeInfo();
    }

    @Test(description = "Product Checkout Test", groups = {"e2e", "smoke", "sanity"},
            retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
    public void checkOutTest() {
        logger.info("Started my Product CheckOut Test");
        assertTrue(productsPage.addProductToCart().proceedToYouCart().proceedToCheckOut()
                .enterInformation(customerInformation).proceedToComplete().getSuccessMessageText().contains("Thank you"));
        logger.info("Completed Product CheckOut Test");
    }


}
