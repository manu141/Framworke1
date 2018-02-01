package com.ebay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ebay.base.TestBase;
import com.ebay.util.TestUtil;

public class HomePage extends TestBase {

	Actions action;
	TestUtil testUtil;
	
	@FindBy(linkText= "Saved")
	WebElement Saved;
	
	@FindBy(linkText= "Motors")
	WebElement Motors;
		
	@FindBy(linkText= "Fashion")
	WebElement Fashion;
	
	@FindBy(linkText= "Electronics")	
	WebElement Electronics;
	
	@FindBy(linkText= "Collectibles & Art")
	WebElement CollectiblesArt;
	
	@FindBy(linkText="Cell Phones & Accessories")
	public WebElement CellPhonesAccessories;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public Electronics clickonElectronics(){
		
		action = new Actions(driver);
		action.moveToElement(Electronics).perform();
		clickOn(driver, CellPhonesAccessories, TIMEOUT);
		//CellPhonesAccessories.click();
		return new Electronics();
	}
	
	public String verifyElectronicsTitle(){
		return driver.getTitle();
	}
}