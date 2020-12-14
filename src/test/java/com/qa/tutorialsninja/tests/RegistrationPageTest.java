package com.qa.tutorialsninja.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.ExcellUtil;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public void registrationPageSetUp() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegistrationData() {
		Object[][] data = ExcellUtil.getTestData("registration");
		return data;
		
	}
	
    @Test(dataProvider="getRegistrationData")
    public void userRegistrationTest() {
    	registrationPage.doRegistartion("kebi", "kekeba", "abc@yahoo.com", "78906789", "12345", "Yes");
    }



}
