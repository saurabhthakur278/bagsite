package com.bags.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bags.utitities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.multipart.FileUpload;

public class Base {
Readconfig readconfig= new Readconfig();
	
	
	String url= readconfig.getbaseUrl();
	String browser= readconfig.getbrowser();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		
		switch (browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
			
		

		default:
			driver=null;
			
			break;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
	}
	//@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
 
	public void captureScreenshot(WebDriver driver, String testName)throws IOException {
		
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir"+"//screenshot"+ testName + ".png"));
		
		FileUtils.copyFile(src, dest);
	}
	
	
	
}
