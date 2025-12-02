package com.ui.pages;

import com.ui.pojo.CustomerInformation;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class CheckOutPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By FIRST_NAME_TEXTBOX_LOCATOR = By.id("first-name");
    private static final By LAST_NAME_TEXTBOX_LOCATOR = By.id("last-name");
    private static final By ZIP_CODE_TEXTBOX_LOCATOR = By.id("postal-code");
    private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");

    public CheckOutPage(WebDriver driver) {
        super(driver);

    }

    public OverviewPage enterInformation(CustomerInformation customerInformation) {
        logger.info("On CheckOut Page");
        logger.info("Entering Customer Information");
        enterText(FIRST_NAME_TEXTBOX_LOCATOR, customerInformation.getFirstName());
        enterText(LAST_NAME_TEXTBOX_LOCATOR, customerInformation.getLastName());
        enterText(ZIP_CODE_TEXTBOX_LOCATOR, customerInformation.getCode());
        clickOn(CONTINUE_BUTTON_LOCATOR);
        return new OverviewPage(getDriver());
    }


}
