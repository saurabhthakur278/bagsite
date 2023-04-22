package com.bags.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement AddToCart;
	
	@FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
	WebElement Cart;
	
	
	@FindBy(id="checkout")
	WebElement buy;
	
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postal;
	
	@FindBy(id="continue")
	WebElement btn;
	
	
	
	@FindBy(id="finish")
	WebElement finish;

	
	
	public void selectitem() {
		AddToCart.click();
		
	}
	

	public void selectcart() {
		Cart.click();
		
	}

	public void buytitem() {
		buy.click();
		
	}
	
	public void address(String fn, String ln, String possod) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		postal.sendKeys(possod);
		btn.click();
	}
	
	public void end() {
		finish.click();
	}
	
	
}
