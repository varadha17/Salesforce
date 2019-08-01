package com.ChangeHealthCare.StepDefinition;

import java.io.IOException;

import com.ChangeHealthCare.Base.base;
import com.ChangeHealthCare.Pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;



public class loginPageTest extends base {

	/**
	 * @Constructor loginPageTest()
	 * @throws IOException
	 */
	public loginPageTest() throws IOException {
		
		super();
		
	}
	
	/**
	 * @Global_Variable
	 */
	public LoginPage login;
	
	/**
	 * @tag Execution begins
	 * @annotation Before
	 * @hooks First
	 * @Start setup()
	 * @throws IOException
	 */
	@Before("@First")
	public void setup() throws IOException {
		
		start();
		
		login = new LoginPage();
		
		
	}
	
	/**
	 * @Scenario_tag_Start After Login, Landing page should be HomePage
	 * @throws Throwable
	 */
	@Given("^Enter the Username and Password$")
	public void Enter_the_Username_and_Password() throws Throwable {             //<1>
	    
		login.sendCredentialsToSalesforceLoginPage();             
		
	}
	
	@When("^Get the Verification code from the mail$")
	public void Get_the_Verification_code_from_the_mail() throws Throwable {    //<2>
	    
		login.getVerificationCodeFromOutlook();
		
	}
	
	/**
	 * @Scenario_tag_End After Login, Landing page should be HomePage
	 * 
	 */
	
	
	/*@Given("^Enter the user with data \"([^\"]*)\"$")
	public void Enter_the_user_with_data(String arg1) throws Throwable {
	    
		
		
	}

	@When("^Enter the pass with data pass \"([^\"]*)\"$")
	public void Enter_the_passw_with_data_pass(String arg1) throws Throwable {
	    
		
		
		
	}*/
	
	/**
	 * @tag Execution Ends
	 * @annotation After
	 * @hooks First
	 * @End teardown()
	 */
	@After("@First")
	public void teardown() {
		
		driver.quit();
		
	}


}
