package com.restassured.listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class RancherTestResults implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        log.info("I am starting the Test:" + result.getName());
    }
}
