package com.demowebshop.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demowebshop.pageObjects.HomePage;
import com.demowebshop.pageObjects.LoginPage;

import dev.failsafe.internal.util.Durations;

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
		initPages();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	
	public LoginPage lp;
	public HomePage hp;
	
	public void initPages() {
		 lp = new LoginPage(driver);
		 hp = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
