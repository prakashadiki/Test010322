package com.catalina.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.catalina.genericLib.WebDriverCommonUtil;

public class LoginPage {
	WebDriverCommonUtil web;
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		web= new WebDriverCommonUtil(driver);
	}
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement LoginLinkEdt;
	
	@FindBy (xpath = "//form//input[@id='loginusername']")
	private WebElement UsernameEdt;
	
	@FindBy (xpath = "//form//input[@id='loginpassword']")
	private WebElement PasswordEdt;
	
	@FindBy (xpath="//button[text()='Log in']")
	private WebElement LoginButton;
	
	
	public WebElement getLoginLinkEdt() {
		return LoginLinkEdt;
		
	}
	
	public WebElement getUsernameEdt() {
		return UsernameEdt;
		
	}
	
	public WebElement getPasswordEdt() {
		return PasswordEdt;
		
	}
	
	public WebElement getLoginButton() {
		return LoginButton;
		
	}
	
	public HomePage loginToApp(String username, String password) {
		LoginLinkEdt.click();
		UsernameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		LoginButton.click();
		return new HomePage(driver);
	}
	
	

}
