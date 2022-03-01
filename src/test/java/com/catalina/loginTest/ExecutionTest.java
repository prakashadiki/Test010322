package com.catalina.loginTest;

import com.catalina.genericLib.BaseClass;
import com.catalina.objectRepoLib.AddToCardPage;
import com.catalina.objectRepoLib.CartPage;
import org.testng.annotations.Test;

import static com.catalina.genericLib.PropertiesLib.getValue;

public class ExecutionTest extends BaseClass {

	@Test
	public void runTest() {
		AddToCardPage addToCardPage = homePage.clickOnSamsungGalaxyS6();
		addToCardPage.clickOnAddToCart();
		addToCardPage.handleThePopUp();
		CartPage cartPage = homePage.navigateToCartPage();
		cartPage.clickOnPlaceOrder();

		String name = getValue("name");
		String country = getValue("country");
		String city = getValue("city");
		String creditCard = getValue("creditCard");
		String month = getValue("month");
		String year = getValue("year");

		cartPage.fillFormToPlaceOrder(name, country, city, creditCard, month, year);
		cartPage.verifyThePurchase();
	}
	
	

}
