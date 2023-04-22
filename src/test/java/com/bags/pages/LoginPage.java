package com.bags.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	
	
@FindBy(id="user-name")
WebElement user;

@FindBy(id="password")
WebElement password;

@FindBy(id="login-button")
WebElement loginbtn;

public void login(String email, String pass) {
	
	user.sendKeys(email);
	password.sendKeys(pass);
	loginbtn.click();
}
	

}
