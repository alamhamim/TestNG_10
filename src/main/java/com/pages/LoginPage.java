package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.Helper;

public class LoginPage {
	
	/*LOGIN PAGE contains login mechanish */
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "txtUsername")
	WebElement userName;
	
	@FindBy(id = "txtPassword")
	WebElement passWord;
	
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	
	public void inputLoginInfo(String username, String password) {
		try {
			
			Helper.type(userName, username);
			Helper.type(passWord, password);
			Helper.waitForElement(driver, loginButton, 10).click();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 
		}
	}
	
	
}
