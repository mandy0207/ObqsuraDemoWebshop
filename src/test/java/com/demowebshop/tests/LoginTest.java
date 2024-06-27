package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void verifyUserIsAbleToLoginWithValidCreds() {
		
	    String actualEmail=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	  
	    String expectedEmail = homePage.getLoggedEmail();
	
	    Assert.assertEquals(actualEmail, "jkbjbjkbk", "Email did not match");
	    
	    
	   	
	}
}
