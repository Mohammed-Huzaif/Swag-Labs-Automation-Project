package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.sql.rowset.BaseRowSet;
import java.util.Arrays;

public class TestListeners implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentReporterUtility.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " " + "FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        ExtentReporterUtility.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());

        Object testClass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
        String path = browserUtility.takeScreenshot(result.getMethod().getMethodName());
        ExtentReporterUtility.getExtentTest().addScreenCaptureFromPath(path);
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReporterUtility.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setUpSparkReporter("report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReporterUtility.flushReport();
    }


}
