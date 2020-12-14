package com.qa.tutorialsninja.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void productInfoSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void verifyProductInfoTest() {
		String productName = "Macbook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		productInfoPage= accountsPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productInfoPage.getProductImages()==4);
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		
		Assert.assertEquals(productInfoMap.get("name"),"MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"),"Apple");
		Assert.assertEquals(productInfoMap.get("price"),"$2000.00");
		Assert.assertEquals(productInfoMap.get("Product code"),"Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"),"800");
	}
      
}
