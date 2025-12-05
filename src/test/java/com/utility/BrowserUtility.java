package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Constructor for passing browsername via String
    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome,Edge or Firefox");
        }
    }

    //Constructor for enums
    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome, Edge or Firefox");
        }
    }

    //Constructor for Headless mode
    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if (isHeadless == true) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browser.EDGE) {
            if (isHeadless == true) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new EdgeDriver());
            }

        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless == true) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome, Edge or Firefox");
        }
    }

    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void maximizeWindow() {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
//        try {
//            Thread.sleep(Duration.ofSeconds(3));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
//        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
//        ((JavascriptExecutor) driver.get()).executeScript("arguments[0].click();", element);
        assert element != null;
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public String takeScreenshot(String name) {

        File folder = new File("./screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        Date date = new Date();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + "-" + timeStamp + ".png";
        System.out.println(path);
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, new File(screenshotFile.getAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
