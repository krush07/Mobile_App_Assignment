package com.test.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	public static Logger log = LogManager.getLogger(Hooks.class);
	
	@Before
    public void beforeScenario() throws Exception{
		driver = capabilities("AppName");
    } 
	
	@After
    public void afterScenario() throws Exception{
		driver.quit();
    } 

}
