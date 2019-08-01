package com.ChangeHealthCare.Base;

/**
 *  @author Varadharajan.Thiruvengadam
 */

//Java Imports
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	/**
	 * @Global_Variables
	 */
	public static Properties prop;
	public static WebDriver driver;
	
	/**
	 * @Constructor Base()
	 * @param Calling Properties file from com.Properties
	 * @throws IOException
	 */
	public base() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Varadharajan.Thiruve\\eclipse-workspace\\SalesForceService\\src\\main\\java\\com\\Properties\\config.properties");
		
		prop.load(fis);
		
	}
	
	/**
	 * @tag Base_ParentClass
	 * @Start start()
	 * @param Defining Browsers Chrome, Firefox, Internet Explorer
	 */
	public static void start() {
		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Varadharajan.Thiruve\\Desktop\\Selenium Jar Files\\ChromeDriver - V75\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
		} else if(BrowserName.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Varadharajan.Thiruve\\Desktop\\Selenium Jar Files\\IE Driver\\IEDriverServer32.exe");
			
			driver = new InternetExplorerDriver();
			
		} else if(BrowserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Varadharajan.Thiruve\\Desktop\\Selenium Jar Files\\Firefox driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	/**
	 * @tag Base_ParentClass
	 * @End start()
	 */

}
