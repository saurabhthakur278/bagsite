package com.bags.tests;

import org.testng.annotations.Test;

import com.bags.pages.LoginPage;

public class TC_Logintest extends Base{

	@Test
	public void varifyragistration()
	{
		
		driver.get("https://www.saucedemo.com/");
		
		LoginPage lp= new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
		
	}

	
}
