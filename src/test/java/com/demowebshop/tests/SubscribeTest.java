package com.demowebshop.tests;

import org.testng.annotations.Test;

import com.demowebshop.pageObjects.LoginPage;

public class SubscribeTest extends BaseTest{

	@Test
	public void verifyUserIsAbleToSubscribeNewsLetter() {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		
		

		
	}
	
}
