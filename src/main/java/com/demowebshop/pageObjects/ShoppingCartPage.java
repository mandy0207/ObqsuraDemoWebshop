package com.demowebshop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.Utils.PageActions;
import com.demowebshop.Utils.UniqueGenerator;

public class ShoppingCartPage extends PageActions {

	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".product-subtotal")
	private WebElement subTotal;
	
	@FindBy(id="CountryId")
	private WebElement countryDropdown;
	
	public String validateShoppingCartPrice() {
		return getElementText(subTotal);
	}
	
	public void checkoutProduct(String country) {
		selectDropdownByVisibleText(countryDropdown, country);
	}

	
}
