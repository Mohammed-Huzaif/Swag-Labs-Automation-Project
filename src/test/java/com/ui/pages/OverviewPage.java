package com.ui.pages;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class OverviewPage extends BrowserUtility {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By FINISH_BUTTON_LOCATOR = By.id("finish");

    public OverviewPage(WebDriver driver) {
        super(driver);

    }

    public CompletePage proceedToComplete() {
        logger.info("On Overview Page");
        clickOn(FINISH_BUTTON_LOCATOR);
        logger.info("Product Ordered Successfully");
        return new CompletePage(getDriver());
    }
}
