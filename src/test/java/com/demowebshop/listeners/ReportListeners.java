package com.demowebshop.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.Utils.PageActions;
import com.demowebshop.Utils.ReportNG;

public class ReportListeners  implements ITestListener{




	ExtentReports extent= ReportNG.generateReport();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		//extentTest.get().addScreenCaptureFromBase64String(PageActions.getScreenshot());
		extentTest.get().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(PageActions.getScreenshot()).build());
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
}
