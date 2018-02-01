package com.ebay.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.util.TestUtil;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static int TIMEOUT = 5;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/ebay/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (System.getProperty("os.name").contains("Windows")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} /*else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver", System.getenv("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}*/ /*else if (System.getProperty("os.name").contains("Mac")) {
				if (browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browserName.equals("FireFox")) {
					System.setProperty("webdriver.gecko.driver",
							System.getenv("user.dir") + "/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}*/
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	//Explicit wait
	public void clickOn(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}