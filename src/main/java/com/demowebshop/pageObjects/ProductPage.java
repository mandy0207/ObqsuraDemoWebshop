package com.demowebshop.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;

public class ProductPage extends PageActions {

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-title a")
	private List <WebElement> searchedProduct;
	
	
	public List<String> validateSearchedItemsAppearAppropriately() {
		return getTextContentList(searchedProduct);
		
	}
	
	
	
}
