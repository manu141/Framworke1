package com.ebay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ebay.base.TestBase;
import com.ebay.pages.HomePage;
import com.ebay.pages.SigninPage;

public class LoginTest extends TestBase {

	SigninPage login;
	HomePage homePage;

	public LoginTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		login = new SigninPage();
	}

	@Test(priority = 2)
	public void signInTest() {
		boolean flag = login.validateSignIn();
		Assert.assertFalse(flag);
	}
	
	@Test(priority = 1)
	public void loginDetails() {
		homePage = login.singin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}