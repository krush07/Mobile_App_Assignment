package com.test.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import com.test.base.Base;
import com.test.pageObjects.LoginScreen;
import com.test.pageObjects.ProductsScreen;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends Base{

	String userName = null;
	String passWord = null;
	LoginScreen loginPage;
	ProductsScreen prodPage;
	
	public StepDefinitions() {
		loginPage = new LoginScreen(driver);
		prodPage = new ProductsScreen(driver);
	}
	

//	@Before("Intialize the driver")
//	public void intialize_the_driver() throws Exception {
//		//service = startAppiumServer();
//		driver = capabilities("AppName");
//		loginPage = new LoginScreen(driver);
//		prodPage = new ProductsScreen(driver);
//		
//	}

	@Given("User have {string} Credentials username {string} and password {string}")
	public void user_have_valid_credentials_username_and_password(String credentialType, String username, String password) {
	    
		userName = username;
		passWord = password;
	}
	
	@When("User enters the Credentials in the Login Screen")
	public void user_enters_the_credentials_in_the_login_screen() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    loginPage.getUsernameElement().sendKeys(userName);
	    loginPage.getPasswordElement().sendKeys(passWord);
	}
	
	@Then("User should be able to successfully login into the application")
	public void user_should_be_able_to_successfully_login_into_the_application() {
	    
		loginPage.getLoginButtonElement().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		assertTrue(prodPage.getTitle().isDisplayed());
		
	}
	
	@And("User should be able to successfully logout from the application")
	public void user_should_be_able_to_successfully_logout_from_the_application() {
		
		prodPage.getmenuButton().click();
		
		loginPage.getLogoutButtonElement().click();
		
		//service.stop();
	}
	
	@And("User should be able to see the 1st product as {string}")
	public void user_should_be_able_to_see_the_1st_product_as(String product1) {
		
		assertEquals(prodPage.getProduct1().getText(), product1);
		
	}
	
	@And("User should be able to see the 2nd product as {string}")
	public void user_should_be_able_to_see_the_2st_product_as(String product2) {
		
		assertEquals(prodPage.getProduct2().getText(), product2);
		
	}

	@Then("User should see error message {string} on Login Screen")
	public void user_should_see_error_message_on_login_screen(String errorMessage) {
		
		loginPage.getLoginButtonElement().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		assertTrue(loginPage.getErrorMessageTextElement().isDisplayed());

		assertEquals(loginPage.getErrorMessageTextElement().getText(), errorMessage);
		
		//service.stop();
	}

}
