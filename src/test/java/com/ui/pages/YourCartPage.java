package com.ui.pages;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class YourCartPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By CHECKOUT_BUTTON_LOCATOR = By.id("checkout");

    public YourCartPage(WebDriver driver) {
        super(driver);
    }


    public CheckOutPage proceedToCheckOut() {
        logger.info("Clicking on CheckOut Button");
        clickOn(CHECKOUT_BUTTON_LOCATOR);
        return new CheckOutPage(getDriver());
    }

}
