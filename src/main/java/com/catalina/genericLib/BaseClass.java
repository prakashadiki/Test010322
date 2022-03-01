package com.catalina.genericLib;

import com.catalina.objectRepoLib.HomePage;
import com.catalina.objectRepoLib.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.catalina.genericLib.PropertiesLib.getValue;


public class BaseClass {
	public  static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	
	@BeforeTest
	public void configBeforeTest() throws Throwable {

		String url = getValue("url");
		String browser = getValue("browser");

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		loginToApp();
	}
	

	public void loginToApp() throws Throwable {
		loginPage = new LoginPage(driver);

		/* get username and password from runtime parameters */
		String username = getValue("userName");
		String password = getValue("password");
		
		homePage = loginPage.loginToApp(username, password);
	}

	

	@AfterTest
	public void configAfterTest() {
		homePage.logOutApp();
		driver.quit();
	}
	

	
}
