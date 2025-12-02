package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BrowserUtility {

    private static final By SUCCESS_MESSAGE_LOCATOR = By.xpath("//h2[contains(text(),'Thank you')]");

    public CompletePage(WebDriver driver) {
        super(driver);
    }


    public String getSuccessMessageText() {
        return getVisibleText(SUCCESS_MESSAGE_LOCATOR);
    }

}
