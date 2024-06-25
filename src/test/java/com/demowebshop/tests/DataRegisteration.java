package com.demowebshop.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.Utils.ExcelReader;
import com.demowebshop.Utils.UniqueGenerator;

public class DataRegisteration extends BaseTest{

	
	@Test
	public void verifyUserIsAbleToRegister() throws IOException {
		String firstName=ExcelReader.getCellValue(1, 0);
		String lastName= ExcelReader.getCellValue(1, 1);
		String email=ExcelReader.getCellValue(1, 2)+UniqueGenerator.getCurrentDateTime()+"@yopmail.com";
		String password=ExcelReader.getCellValue(1, 3);
		
		loginPage.navigateToRegisteration();
	    registerPage.createUser(firstName,lastName, email, password, password);
		
		Map<String, String> dataMap = registerPage.validateRegisterationPageItems();
		Assert.assertEquals(dataMap.get("alertText"), prop.getProperty("registerationMsg"), "Alert did not match" );
		Assert.assertEquals(dataMap.get("loggedEmail"), email, "Logged Email is different" );
	}
}
