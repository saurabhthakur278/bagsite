package com.bags.tests;

import org.testng.annotations.Test;

import com.bags.pages.HomePage;

public class TC_homepage extends Base{
	
	@Test
	public void buyBags() {
		
		TC_Logintest lt=new TC_Logintest();
		lt.varifyragistration();
		
		HomePage hp=new HomePage(driver);
		hp.selectitem();
		hp.selectcart();
		hp.buytitem();
		hp.address("Sa", "tha", "444706");
		hp.end();
	}
}
