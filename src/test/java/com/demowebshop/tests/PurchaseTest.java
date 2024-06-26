package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PurchaseTest extends BaseTest {

	@Test
	public void verifyUserIsAbleToBuyAProduct() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		loginPage.navigateToRegisteration();
		registerPage.createUser(firstName,lastName, email, password, password);
		
		loginPage.searchItem(prop.getProperty("itemToSearch"));
		String actualPrice=productPage.addTocart().navigateToCart();
		String expectedPrice=shoppingPage.validateShoppingCartPrice();
		Assert.assertEquals(actualPrice, expectedPrice, "Price difference in cart");
		shoppingPage.checkoutProduct(prop.getProperty("country"));
	}
}
