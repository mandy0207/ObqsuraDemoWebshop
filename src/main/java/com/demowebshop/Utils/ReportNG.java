package com.demowebshop.Utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demowebshop.Context.Constants;

public class ReportNG {
	static ExtentSparkReporter reporter;

	public static ExtentReports generateReport() {

		reporter = new ExtentSparkReporter(Constants.reportPath);
		loadXMLFIle();
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Anjali");
		extent.setSystemInfo("Brand", "Demo WebShop");
		return extent;
	}

	public static void loadXMLFIle() {
		try {
			reporter.loadXMLConfig(Constants.extentConfigFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
