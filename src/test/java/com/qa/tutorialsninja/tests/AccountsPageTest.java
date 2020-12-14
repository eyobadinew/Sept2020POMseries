package com.qa.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=2)
	public void accountsPageTitleTest() {
		String title= accountsPage.getAccountsPageTitle();
		System.out.println("The Accounts page title is " +title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
		
	}
	
	@Test(priority=1)
	public void verifyAccountsPageHeader() {
		String headerValue = accountsPage.getheaderValue();
		System.out.println("The AccountsPage Header is :"+headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}
	@Test(priority=3)
	public void verifyMyaccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionsCount()==Constants.ACCOUNT_SECTIONS);
	}
	@Test(priority=4)
	public void verifyMyaccountSectionsListTest() {
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}
   @Test(priority=5)
   public void searchTest() {
	   Assert.assertTrue(accountsPage.doSearch("iMac")); 
   }
}

