package com.qa.tutorialsninja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the browser on the basis of the given browser
	 * @author eyoba
	 *
	 */
		

	public WebDriver init_driver(String browser) {
		System.out.println("The browser value is" +browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {System.out.println("The browser is "+browser);
			}
	    driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
	
			
       return driver;
	
	}
	
	
	/**
	 * This method is used to load properties from config.properties file
	 * @return it returns Properties prop reference
	 */

	public Properties init_properties() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/tutorialsninja/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
	

}
