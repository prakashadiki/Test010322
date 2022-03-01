package com.catalina.objectRepoLib;

import com.catalina.genericLib.WebDriverCommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class CartPage {

	private final WebDriver driver;
	WebDriverCommonUtil web;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		web = new WebDriverCommonUtil(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElement PlaceOrderEdt;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement NameFieldEdt;

	@FindBy(xpath = "//input[@id='country']")
	private WebElement CountryNameEdt;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement CityNameEdt;

	@FindBy(xpath = "//input[@id='card']")
	private WebElement CardFieldEdt;

	@FindBy(xpath = "//input[@id='month']")
	private WebElement MonthsFieldEdt;

	@FindBy(xpath = "//input[@id='year']")
	private WebElement YearFieldEdt;

	@FindBy(xpath = "//button[text()='Purchase']")
	private WebElement PurchaseButtonEdt  ;

	@FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']//h2") private WebElement purchaseConfirmEle;
	@FindBy(xpath = "//button[text()='OK']") private WebElement okButton;

	public void clickOnPlaceOrder() {
		web.waitForElemetToBePresent(PlaceOrderEdt);
		wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderEdt)).click();
	}

	public void fillFormToPlaceOrder(String name, String country, String city, String creditCard, String month, String year) {
		wait.until(ExpectedConditions.visibilityOf(NameFieldEdt)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOf(CountryNameEdt)).sendKeys(country);
		wait.until(ExpectedConditions.visibilityOf(CityNameEdt)).sendKeys(city);
		wait.until(ExpectedConditions.visibilityOf(CardFieldEdt)).sendKeys(creditCard);
		wait.until(ExpectedConditions.visibilityOf(MonthsFieldEdt)).sendKeys(month);
		wait.until(ExpectedConditions.visibilityOf(YearFieldEdt)).sendKeys(year);
		wait.until(ExpectedConditions.elementToBeClickable(PurchaseButtonEdt)).click();
	}


	public void verifyThePurchase() {
		wait.until(ExpectedConditions.visibilityOf(purchaseConfirmEle));
		String purchaseConfirmEleText = purchaseConfirmEle.getText();
		assertEquals(purchaseConfirmEleText.trim(), "Thank you for your purchase!");
		web.takeSnapShot();
		wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
	}

}
