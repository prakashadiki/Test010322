package com.catalina.objectRepoLib;

import com.catalina.genericLib.WebDriverCommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCardPage {

	WebDriver driver;
	WebDriverCommonUtil web;
	WebDriverWait wait;

	public AddToCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		web = new WebDriverCommonUtil(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}


	@FindBy (xpath="//a[text()='Add to cart']")
	private WebElement AddCardLinkEdt;
	
	@FindBy (xpath="//a[text()='Cart']")
	private WebElement CardLinkEdt;

	public void clickOnAddToCart() {
		web.waitForElemetToBePresent(AddCardLinkEdt);
		wait.until(ExpectedConditions.elementToBeClickable(AddCardLinkEdt)).click();
	}

	public void handleThePopUp() {
		wait.until(ExpectedConditions.alertIsPresent());
		web.acceptAlert();
	}
	

}
