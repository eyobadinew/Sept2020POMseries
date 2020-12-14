package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.Constants;
import com.qa.tutorialsninja.utils.ElementUtil;

public class LoginPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	// 1. By Locators: also known as OR (Object Repositories)
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login' and @type='submit']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	private By registerLink = By.linkText("Register");
	
	// 2. Constructor of the page class
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	//	3. Page Actions : or the features(behaviors) of the page in the form of methods
	public String getLoginPageTitle() {
			//	return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
    public boolean isforgotPwdLinkExist() {
    	//return driver.findElement(forgotPwdLink).isDisplayed();
    	return elementUtil.doIsDisplayed(forgotPwdLink);
    }
    public AccountsPage doLogin(String un,String pwd) {
    	//driver.findElement(emailId).sendKeys(un);
    	//driver.findElement(password).sendKeys(pwd);
    	//driver.findElement(loginButton).click();
    	elementUtil.doSendKeys(emailId, un);
    	elementUtil.doSendKeys(password, pwd);
    	elementUtil.doClick(loginButton);
    	
    	
    	return new AccountsPage(driver);
    }
    
    public RegistrationPage navigateToRegisterPage() {
    	elementUtil.doClick(registerLink);
    	return new RegistrationPage(driver);
    }
}

