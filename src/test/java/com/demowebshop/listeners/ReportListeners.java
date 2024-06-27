package com.demowebshop.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.Utils.ReportNG;

public class ReportListeners implements ITestListener{

	ExtentReports extent= ReportNG.generateReport();
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
}
