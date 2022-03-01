package com.catalina.genericLib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static com.catalina.genericLib.DateLibrary.getDateDDMMYYYY;

public class WebDriverCommonUtil  {


	private final WebDriver driver;

	public WebDriverCommonUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPageToLoad()  {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		
	
	}
	
	public void javaScriptTest(WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * Wait for element to be available on GUI
	 * @param element
	 */
	public void waitForElemetToBePresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Select the Option based on text in GUI
	 * @param element
	 * @param data to be selected
	 */
	public void selectOption(WebElement element, String data){
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}
	
	/**
	 * Select the option based on index
	 * @param element
	 * @param index of the option
	 */
	public void selectOption(WebElement element, int index){
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * Select the value from the dynamic select dropDown
	 * @param element
	 * @param data
	 * @return boolean if the option was selected
	 */
	public boolean selectDynamicOption(WebElement element, String data){
		Select sel = new Select(element);
		List<WebElement> options = sel.getOptions();
		for(WebElement option:options) {
			if(option.getText().equals(data)) {
				sel.selectByVisibleText(data);
				return true;
			}
		}
		return false;
	}

	public void setTime(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void takeSnapShot(){
		try {
			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("target/screenshot/"+getDateDDMMYYYY()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
