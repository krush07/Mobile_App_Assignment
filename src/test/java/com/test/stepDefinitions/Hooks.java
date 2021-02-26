package com.test.stepDefinitions;

import com.test.base.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	@Before
    public void beforeScenario() throws Exception{
		driver = capabilities("AppName");
    } 
	
	@After
    public void afterScenario() throws Exception{
		driver.quit();
    } 

}
