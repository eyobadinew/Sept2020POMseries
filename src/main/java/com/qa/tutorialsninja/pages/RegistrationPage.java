package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class RegistrationPage extends BasePage {
    private ElementUtil elementUtil;
	
	private By firstName  = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline']/input)[1]");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline']/input)[2]");
	private By privacyPolicyCheckBox = By.xpath("//input[@type='checkbox' and @name ='agree' and@value='1']");
	private By continueButton =By.xpath("//input[@type='submit' and@value='Continue']");
	
	//private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
	//private By logout =By.linkText("Logout");
	//private By register = By.linkText("Register");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public void doRegistartion(String firstName,String lastName,String email,String telephone,String password,String subscribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("Yes")) {
		elementUtil.doClick(this.subscribeYes);
	}
		else if(subscribe.equalsIgnoreCase("No")) {
			elementUtil.doClick(subscribeNo);
		}
	    elementUtil.doClick(privacyPolicyCheckBox);
	    elementUtil.doClick(continueButton);
	}
	
	// the following method code is created for git hub update check
	public void rememberMe() {
		System.out.println("remember me test");
	}
}
