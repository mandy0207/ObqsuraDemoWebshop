package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.UniqueGenerator;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[@class='header-links']//a)[1]")
	private WebElement loggedEmail;
	
	@FindBy(id="newsletter-email")
	private WebElement newsLetterEmail;
	
	@FindBy(id="newsletter-subscribe-button")
	private WebElement newsLetterSubscribeBtn;
	
	@FindBy(id="newsletter-result-block")
	private WebElement newsLetterAlertMsg;
	
	
	
	public String getLoggedEmail() {
		return loggedEmail.getText();
	}
	
	public String subcribeNewsLetter() throws InterruptedException {
		newsLetterEmail.sendKeys(UniqueGenerator .getUniqueEmail());
		newsLetterSubscribeBtn.click();
		Thread.sleep(2000);
		return newsLetterAlertMsg.getText();
		
	}
	
}
