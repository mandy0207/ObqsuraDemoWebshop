package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
 
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css="[class='ico-login']")
	private WebElement loginHeader;
	
	@FindBy(id="Email")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//*[@class='buttons']/input[@value='Log in']")
	private WebElement loginBtn;
	
	
	
	public void login() {
		loginHeader.click();
		emailInput.sendKeys("obsqura24@gmail.com");
		passwordInput.sendKeys("mypassword");
		loginBtn.click();
	}
	
	
	
	
	
}
