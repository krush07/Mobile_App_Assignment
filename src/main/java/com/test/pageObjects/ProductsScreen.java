package com.test.pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsScreen {
	
	public ProductsScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath="//android.widget.TextView[@text='PRODUCTS']")
	private AndroidElement title;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@package='com.swaglabsmobileapp']/following-sibling::android.widget.TextView[@text='Sauce Labs Backpack']")
	private AndroidElement product1;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@package='com.swaglabsmobileapp']/following-sibling::android.widget.TextView[@text='Sauce Labs Bike Light']")
	private AndroidElement product2;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-Menu']")
	private AndroidElement menuButton;

	public AndroidElement getTitle() {
		return title;
	}

	public AndroidElement getProduct1() {
		return product1;
	}
	
	public AndroidElement getProduct2() {
		return product2;
	}
	
	public AndroidElement getmenuButton() {
		return menuButton;
	}
	
	
	
	
}
