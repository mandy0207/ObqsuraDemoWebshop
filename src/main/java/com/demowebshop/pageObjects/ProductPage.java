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
	
	@FindBy(xpath="//*[@value='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(css=".ico-cart .cart-label")
	private WebElement shoppingCartHeader;
	
	@FindBy(css="[value='Go to cart']")
	private WebElement goToCartBtn;
	
	@FindBy(css=".ico-cart .cart-qty")
	private WebElement qty;
	
	@FindBy(xpath="//*[@value='Add to cart']/../preceding-sibling::*/span")
	private WebElement priceOfProduct;
	
	
	
	public List<String> validateSearchedItemsAppearAppropriately() {
		return getTextContentList(searchedProduct);
		
	}
	
	public ProductPage addTocart() {
		clickElement(addToCartBtn);
		return this;
	}
	
	public String navigateToCart() {
		String price=getElementText(priceOfProduct);
		waitForTextPresentInElement(qty, "(1)");
		hoverOverItem( shoppingCartHeader);
		clickElement(goToCartBtn);
		return price;
		
	}
	
}
