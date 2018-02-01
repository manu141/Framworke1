package com.ebay.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ebay.pages.SigninPage;
import com.ebay.base.TestBase;
import com.ebay.pages.HomePage;
import com.ebay.util.TestUtil;

public class HomePageTest extends TestBase {
	HomePage home;
	SigninPage sign;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		sign = new SigninPage();
		testUtil = new TestUtil();
		home = sign.singin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyElectronicsIsClicked(){
		home.clickonElectronics();
		Assert.assertEquals((home.verifyElectronicsTitle()), "Cell Phones, Smart Watches & Accessories | eBay");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}