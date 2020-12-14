package com.qa.tutorialsninja.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class ProductInfoPage extends BasePage{
    private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1)");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2)");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By images =By.cssSelector(".thumbnails li img");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public Map<String,String> getProductInformation() {
		Map<String,String> productInfoMap = new HashMap<>(); 
		productInfoMap.put("name", elementUtil.doGetText(productNameHeader));
	List<WebElement> productMetaDataList = elementUtil.getElements(productMetaData);
		for(WebElement e:productMetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
	 List<WebElement> productPriceList = elementUtil.getElements(productPrice);
	 productInfoMap.put("price",productPriceList.get(0).getText().trim());
	 productInfoMap.put("exTaxPrice",productPriceList.get(1).getText().split(":")[1].trim());
	 
	 return productInfoMap;
	}
	
	public void selectQuantity(String qty) {
		elementUtil.doSendKeys(quantity, qty);
	}
	public void addToCart() {
		 elementUtil.doClick(addToCartButton);
	}
	public int getProductImages() {
		int imageCount = elementUtil.getElements(images).size();
		System.out.println("Total images count is :"+imageCount);
		return imageCount;
	}
    
}
