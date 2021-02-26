package com.test.pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.test.base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
	
	public static Logger log = LogManager.getLogger(LoginScreen.class);

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Username']")
	private AndroidElement usernameElement;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private AndroidElement passwordElement;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-LOGIN']")
	private AndroidElement loginButtonElement;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-LOGOUT']")
	private AndroidElement logoutButtonElement;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
	private AndroidElement errorMessageTextElement;
	

	public AndroidElement getUsernameElement() {
		return usernameElement;
	}

	public AndroidElement getPasswordElement() {
		return passwordElement;
	}

	public AndroidElement getLoginButtonElement() {
		return loginButtonElement;
	}

	public AndroidElement getLogoutButtonElement() {
		return logoutButtonElement;
	}

	public AndroidElement getErrorMessageTextElement() {
		return errorMessageTextElement;
	}
	
	
	
	


}
