package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeTest extends BaseTest{

	@Test
	public void verifyUserIsAbleToSubscribeNewsLetter() throws InterruptedException {
		
		 loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		 String actualAlertMsg = homePage.subcribeNewsLetter();
		 Assert.assertEquals(actualAlertMsg, prop.getProperty("subscriptionMsg"), "Alert message not mataching");
		 
		
	}
	
}
