package com.demowebshop.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.demowebshop.Context.DriverManager;
import com.demowebshop.Utils.TestProperties;
import com.demowebshop.pageObjects.HomePage;
import com.demowebshop.pageObjects.LoginPage;
import com.demowebshop.pageObjects.ProductPage;
import com.demowebshop.pageObjects.RegisterPage;
import com.demowebshop.pageObjects.ShoppingCartPage;

public class BaseTest {
	WebDriver driver;
	Properties prop;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"browserName"})
	public void initializeDriver(@Optional String browserName) throws IOException {
		prop = TestProperties.getProperties();
		if ( browserName == null || browserName.isEmpty()) {
			System.out.println("hello");
			browserName = prop.getProperty("browser");
		}

	

		String env = prop.getProperty("envrionment");
		String URL = prop.getProperty(env);

		System.out.println("Executing in : " + env);

		getDriver(browserName);
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		initPages();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DriverManager.getDriver().get(URL);
	}

	public void getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Not a valid browser");
		}
	}

	public LoginPage loginPage;
	public HomePage homePage;
	public RegisterPage registerPage;
	public ProductPage productPage;
	public ShoppingCartPage shoppingPage;

	public void initPages() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		productPage = new ProductPage(driver);
		shoppingPage = new ShoppingCartPage(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverManager.getDriver().quit();

	}

}
