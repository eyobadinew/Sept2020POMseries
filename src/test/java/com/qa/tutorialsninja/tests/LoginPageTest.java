package com.qa.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		
		String title = loginPage.getLoginPageTitle();
		System.out.println("The login page title is"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	 public void verifyForgetPwdLinkTest() {
		 Assert.assertTrue(loginPage.isforgotPwdLinkExist());
	 }
    @Test(priority = 3)
    public void LoginTest() {
    	loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    	    }
}

	
	
	
	
	
	

