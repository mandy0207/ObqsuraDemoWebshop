package com.demowebshop.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demowebshop.Context.Constants;

public class ReportNG {

	public static ExtentReports generateReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.reportPath);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Demo WebShop");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Anjali");
		extent.setSystemInfo("Brand", "Demo WebShop");
		return extent;
	}
}
