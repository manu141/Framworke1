package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.base.TestBase;

public class SigninPage extends TestBase {
	
	//PageFactory - Object Repository
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	WebElement signIn;
	 
	@FindBy(xpath="//input[@id='userid']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='sgnBt']")
	WebElement signinBtn;
	
	@FindBy(xpath="//a[contains(text(),'register')]")
	WebElement register;
	
	//Initializing the Page Objects:
	public SigninPage(){
		//PageFactory.initElements(driver, SigninPage.class);
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public boolean validateSignIn(){
		return signIn.isDisplayed();
	}
	
	public HomePage singin(String un, String pwd){
		signIn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signinBtn.click();
		return new HomePage();
	}
}