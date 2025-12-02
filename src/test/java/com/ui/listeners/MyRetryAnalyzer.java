package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    //reading from properties file
    //private static final int MAX_ATTEMPTS =Integer.parseInt( PropertiesUtility.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS" ));

    //reading from json file
    private static final int MAX_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (currentAttempt <= MAX_ATTEMPTS) {
            currentAttempt++;
            return true;
        }


        return false;
    }
}
