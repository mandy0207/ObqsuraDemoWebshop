package com.demowebshop.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class RegisterationTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToRegisterWithValidCreds() {
		
		loginPage.navigateToRegisteration();
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String password= faker.internet().password();
		
		registerPage.createUser(firstName,lastName, email, password, password);
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems();
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		Assert.assertEquals(dataMap.get("loggedEmail"), email, "Logged Email is different" );
		
	}
}

