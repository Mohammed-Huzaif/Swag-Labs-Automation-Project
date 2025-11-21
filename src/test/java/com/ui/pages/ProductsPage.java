package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BrowserUtility {

    private static final By PRODUCTS_TITLE_LOCATOR = By.xpath("//div[@data-test='secondary-header']/span");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsHeading(){
       return getVisibleText(PRODUCTS_TITLE_LOCATOR);
    }

}
