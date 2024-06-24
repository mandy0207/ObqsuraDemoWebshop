package com.demowebshop.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageActions {

	WebDriver driver;
	
	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickElement(WebElement element) {
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.click();
	}
	
	public void setTextBox(WebElement element, String value) {
		waitUntilVisible(element);
		waitUntilClickable(element);
		element.sendKeys(value);
	}
	
	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	public void waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public void clickElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		waitUntilVisible(element);
		waitUntilClickable(element);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public List<String> getTextContentList(List<WebElement> list) {
		List<String> textContent= new ArrayList<String>();
		for(WebElement listItem : list) {
			textContent.add(getElementText(listItem));
		}
		return textContent;
	}
	
}
