package com.ui.pages;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class ProductsPage extends BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    private static final By PRODUCTS_TITLE_LOCATOR = By.xpath("//div[@data-test='secondary-header']/span");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("(//button[text()='Add to cart'])[1]");
    private static final By SHOPPING_CART_CONTAINER_LOCATOR = By.id("shopping_cart_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsHeading() {
        return getVisibleText(PRODUCTS_TITLE_LOCATOR);
    }

    public ProductsPage addProductToCart() {
        logger.info("Adding Product to the Cart");
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return new ProductsPage(getDriver());
    }

    public YourCartPage proceedToYouCart() {
        logger.info("Product Added to the Cart");
        clickOn(SHOPPING_CART_CONTAINER_LOCATOR);
        return new YourCartPage(getDriver());
    }


}
