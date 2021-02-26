package com.test.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	public static Logger log = LogManager.getLogger(Base.class);
	
	public AppiumDriverLocalService startAppiumServer() {
		
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag) {
			service = AppiumDriverLocalService.buildService(
					new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
			
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e) {
			isServerRunning = true;
		}finally {
			serverSocket = null;
		}
		
		return isServerRunning;
	}
	
	public static void startEmulator() throws Exception {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\emulators\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws Exception {
		
		System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		//AndroidDriver<AndroidElement> driver;
		
		File appDir = new File("src");
		File app = new File(appDir,prop.getProperty(appName));
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//startEmulator();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("AutomationName"));
		capabilities.setCapability("appPackage","com.swaglabsmobileapp");
		capabilities.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
	}

}
