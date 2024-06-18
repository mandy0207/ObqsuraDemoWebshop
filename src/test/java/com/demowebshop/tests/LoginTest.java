package com.demowebshop.tests;

import org.testng.annotations.Test;

import com.demowebshop.pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void verifyUserIsAbleToLoginWithValidCreds() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login();
	    
	    
		
	}
}
