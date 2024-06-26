package com.demowebshop.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.model.Person;
import com.github.javafaker.Faker;

public class RegisterationTest extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToRegisterWithValidCreds() {
		
		
		Faker faker = new Faker();
		String password= faker.internet().password();
		
		Person person = new Person(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(), password, password);
		
		loginPage.navigateToRegisteration();
		registerPage.createUser(person.firstName,person.lastName, person.email, person.password, person.confirmPassword);
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems();
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		Assert.assertEquals(dataMap.get("loggedEmail"), person.email, "Logged Email is different" );
		
	}
}

