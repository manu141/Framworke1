package com.ebay.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ebay.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICIT_WAIT= 10;
	
	
	//Taking Screenshot
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir + "screenshots" 
		+System.currentTimeMillis() + ".png"));	
	}
	
	//Switch to Frame
	public void swithToFrame(){
		driver.switchTo().frame("mainpanel");
	}	
}