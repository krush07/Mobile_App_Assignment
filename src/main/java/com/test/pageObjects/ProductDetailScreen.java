package com.test.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailScreen {
	
	public static Logger log = LogManager.getLogger(ProductDetailScreen.class);
	
	public ProductDetailScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']")
	public AndroidElement backToProductButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='0']")
	public AndroidElement productNameText;
}
