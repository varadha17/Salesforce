package com.ChangeHealthCare.Pages;

/**
 * @author Varadharajan.Thiruvengadam
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//Java Imports
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
//Selenium Imports
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Class Import
import com.ChangeHealthCare.Base.base;

/**
 * Login Class Extends base
 */
public class LoginPage extends base {
	
	/**
	 * @Global_Variables 
	 */
	private static Set<String> window;
	private static Iterator<String> iterate;
	private static String parentWindow, childWindow, code, getEmailSubject, getEmailBodyMessage;
	private Robot newTab;
	
	/**
	 * @Constructor LoginPage()
	 * @throws IOException
	 */
	public LoginPage() throws IOException {
		
		super();
		
		PageFactory.initElements(driver, this); //It will store the WebElements of current class
		
	} 
	
	/**
	 * @WebElement:: Login Page
	 */
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="Login")
	WebElement LoginButton;
	
	/**
	 * @WebElement:: Mail Page
	 */
	@FindBy(css="input[type='email']")
	WebElement email;
	
	@FindBy(css="input[type='submit']")
	WebElement submit;
	
	@FindBy(css="input[type='password']")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Filter')]")
	WebElement filter;
	
	@FindBy(xpath="(//span[contains(text(),'Unread')])[2]")
	WebElement unread;
	
	@FindBy(xpath="//span[contains(text(),'(External Email) Sandbox: Verify your identity in Salesforce')]")
	WebElement Subjecttext;
	
	@FindBy(xpath="//p[contains(normalize-space(),'Verification Code:')]")
	WebElement EmailBodyMessage;
	
	/**
	 * @WebElement:: Verification Code Page
	 */
	@FindBy(id="emc")
	WebElement VerificationCode;
	
	@FindBy(id="save")
	WebElement VerifyButton;

	/**
	 * @tag LoginPage
	 * @Start sendCredentialsToSalesforceLoginPage()
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void sendCredentialsToSalesforceLoginPage() throws IOException, InterruptedException {
		
		/*Username.sendKeys(prop.getProperty("Username"));
		Password.sendKeys(prop.getProperty("Password"));
		LoginButton.click();*/
		
		System.out.println("Google Launched");
		Thread.sleep(3000);

	}
	
	/**
	 * @tag LoginPage
	 * @End sendCredentialsToSalesforceLoginPage()
	 */
	
	
	/**
	 * @tag Verification Code Page
	 * @Start getVerificationCodeFromOutlook()
	 * @return HomePage Class(C:\Users\Varadharajan.Thiruve\eclipse-workspace\SalesForceService\src\main\java\com\ChangeHealthCare\Pages\HomePage.java)
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws IOException
	 */
	public HomePage getVerificationCodeFromOutlook() throws InterruptedException, AWTException, IOException {
		
		//Robot Framework
		newTab = new Robot();
		newTab.keyPress(KeyEvent.VK_CONTROL);
		newTab.keyPress(KeyEvent.VK_T);
		newTab.keyRelease(KeyEvent.VK_T);
		newTab.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		
		//Window handles
		window = driver.getWindowHandles();
		iterate = window.iterator();
		parentWindow = iterate.next();
		childWindow = iterate.next();
		System.out.println(parentWindow);
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		
		driver.get(prop.getProperty("MailUrl"));
		
		email.sendKeys(prop.getProperty("MailUsername"));
		submit.click();
		password.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(3000);
		submit.click();
		Thread.sleep(20000);
		filter.click();
		Thread.sleep(3000);
		unread.click();
		Thread.sleep(5000);
		
		getEmailSubject = Subjecttext.getText();
		System.out.println(getEmailSubject);
		
		if(Subjecttext.isDisplayed()) {
			Thread.sleep(2000);
			Subjecttext.click();
		}

		getEmailBodyMessage = EmailBodyMessage.getText();
		code = getEmailBodyMessage.substring(339, 344);
		System.out.println("Verification code: "+code);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);

		return new HomePage();

	}
	
	/**
	 * @tag Verification Code Page
	 * @return HomePage Class(C:\Users\Varadharajan.Thiruve\eclipse-workspace\SalesForceService\src\main\java\com\ChangeHealthCare\Pages\HomePage.java)
	 * @End getVerificationCodeFromOutlook()
	*/ 

}
