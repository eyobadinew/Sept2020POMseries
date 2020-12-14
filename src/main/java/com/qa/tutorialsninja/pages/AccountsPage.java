package com.qa.tutorialsninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class AccountsPage extends BasePage {

		private WebDriver driver;
		private ElementUtil elementUtil;
		
		private By header = By.cssSelector("div#logo a");
		private By accountSectionHeaders = By.cssSelector("div#content h2");
	    private By searchText = By.cssSelector("div#search input[name='search']");
	    private By searchButton = By.cssSelector("div#search button[type='button']"); 
	    private By searchItemResult = By.cssSelector(".product-layout .product-thumb");
	    private By resultItems = By.cssSelector(".product-thumb h4 a");

	    public AccountsPage(WebDriver driver) {
	    	this.driver = driver;
	    	elementUtil = new ElementUtil(driver);
	        }

	    public String getAccountsPageTitle() {
			return driver.getTitle();
		}
	  public String getheaderValue() {
		  if(driver.findElement(header).isDisplayed()) {
		  return driver.findElement(header).getText();
		  }
		  return null;
	  }
	 public int getAccountSectionsCount() {
		 return driver.findElements(accountSectionHeaders).size();
	 }
	   public List<String> getAccountSectionsList() {
		   List<String> acctList = new ArrayList<>();
		   List<WebElement> acctSectionList = driver.findElements(accountSectionHeaders);
		  for(WebElement e:acctSectionList) {
			 acctList.add(e.getText());
		  }
		  return acctList;
	   }
	   public boolean doSearch(String productName) {
		   driver.findElement(searchText).sendKeys(productName);
		   driver.findElement(searchButton).click();
		   if(driver.findElements(searchItemResult).size()>0) {
			   return true;
		   }
		   return false;
	   }
	  public ProductInfoPage selectProductFromResults(String productName) {
		  List<WebElement> resultItemList = elementUtil.getElements(resultItems);
		  for(WebElement e:resultItemList) {
			 if(e.getText().equalsIgnoreCase(productName));
			 e.click();
			 break;
		  }
		  return new ProductInfoPage(driver);
	  }

	}


