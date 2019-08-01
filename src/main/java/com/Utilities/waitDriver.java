package com.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChangeHealthCare.Base.base;

public class waitDriver extends base {

	/**
	 * @Constructor waitDriver()
	 * @throws IOException
	 */
	public waitDriver() throws IOException {
		
		super();
		
	}
	
	/**
	 * @tag Explicit wait
	 * @Start ExpWait()
	 * @param driver
	 * @param element
	 * @param timeout
	 */
	public static void ExpWait(WebDriver driver, WebElement element, int timeout){
		
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));	
		element.click();
		
		}
	
	/**
	 * @tag Explicit wait
	 * @End ExpWait()
	 */

}
