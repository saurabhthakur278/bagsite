package com.bags.utitities;

import org.testng.ITestListener;

import java.io.File;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


//com.bags.utitities.ExtentListner
public class ExtentListner implements ITestListener
{
	public ExtentSparkReporter htmlreport;
	public ExtentReports reports;
	public ExtentTest test;
	
	public void configureReport() {
		
		htmlreport= new ExtentSparkReporter("ExtentListenerReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		
		
		reports.setSystemInfo("machine", "testpc1");
		reports.setSystemInfo("os", "windows11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("username", "saurabh");
		
		htmlreport.config().setDocumentTitle("Extent report Demo");
		htmlreport.config().setReportName("first report");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		
		
	}

	
	public void onStart(ITestContext Result) {
		
		configureReport();
		System.out.println("on start method invoke");
	}
	
public void onfinish(ITestContext Result) {
		
		
		System.out.println("on finish method invoke");
		reports.flush();
	}




public void onTestFailure(ITestContext Result) {
	
	
	System.out.println("on test method fail"+Result.getName());
	
	test=reports.createTest(Result.getName());
	test.log(Status.FAIL, MarkupHelper.createLabel("name of failed TC"+Result.getName(), ExtentColor.RED));
	String screenShotsPath =System.getProperty("user.dir")+"\\screenshot\\"+Result.getName()+".png";
	
	File screenshot=new File(screenShotsPath);
	
	if(screenshot.exists()) {
			test.fail("capture screen shot is below"+ test.addScreenCaptureFromPath(screenShotsPath));
	}
}


public void onTestSkip(ITestContext Result) {
	
	
	System.out.println("on test method skipped"+Result.getName());
	test=reports.createTest(Result.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel("name of skipped TC"+Result.getName(), ExtentColor.BROWN));	
	
}


public void onTestStart(ITestContext Result) {
	
	System.out.println("on test method fail"+Result.getName());
		
}


public void onTestSuccess(ITestContext Result) {
	
	
	System.out.println("on test method fail"+Result.getName());
	
	test=reports.createTest(Result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel("name of passed TC"+Result.getName(), ExtentColor.GREEN));
}
	
	
	
	
	
	
	
}
