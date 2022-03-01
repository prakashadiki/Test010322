package com.catalina.objectRepoLib;

import com.catalina.genericLib.WebDriverCommonUtil;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

	private final WebDriver driver;
	WebDriverCommonUtil web;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		web = new WebDriverCommonUtil(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(id = "logout2") private WebElement logoutLink;
	@FindBy (xpath="//body/div[@id='contcont']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]") private WebElement SamsungLink;
	@FindBy(xpath = "//a[text()='Samsung galaxy s6']") private WebElement samsungGalaxyS6Link;
	@FindBy(id = "next2") private WebElement nextPage;
	@FindBy(xpath = "//a[text()='Cart']") private WebElement cartPageLink;



	public void logOutApp() {
		web.waitForElemetToBePresent(logoutLink);
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
	}

	public AddToCardPage clickOnSamsungGalaxyS6() {
		int count = 0;
		while (count < 5) {
			try {
				samsungGalaxyS6Link.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				nextPage.click();
				count++;
			}
		}
		if (count == 2)
			throw new RuntimeException("[ERROR] required element not present in the DOM document.");

		web.javaScriptTest(samsungGalaxyS6Link);
		web.setTime(2000);
		wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxyS6Link)).click();
		return new AddToCardPage(driver);
	}

	public CartPage navigateToCartPage() {
		wait.until(ExpectedConditions.elementToBeClickable(cartPageLink)).click();
		return new CartPage(driver);
	}



}
