package com.demowebshop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;

	@BeforeMethod
	public void initializeDriver() {
		String browser = "chrome";
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Not a valid browser");
		}
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
