package com.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.browsers.BrowserConfig;
import com.dataProvider.BrowserDataProvider;
import com.pages.LoginPage;
import com.util.Helper;

public class BaseTest {
	
	WebDriver driver;
	ExtentTest logger; //extent test is a logger
	ExtentReports reports; //extent report for report
	LoginPage loginPage;
	BrowserDataProvider browserData;
	 
	
	@BeforeClass
	public void getTestData() throws IOException {
		browserData = new BrowserDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("Reports/TestReorts_"+Helper.getDateAndTime()+".html")); //for generating the html report
		reports = new ExtentReports();
		reports.attachReporter(extent); //creating report in html report
		logger = reports.createTest("Login Test");
	}
	
	@BeforeMethod
	public void browserSetup() {
		driver = BrowserConfig.startAPP(driver, browserData.getBrowser(), browserData.getUrl());
		
	}
	
	@AfterMethod
	public void testResult(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test is Failed");
			Helper.takeScreenShot(driver);
			
		} else {
			logger.pass("Test passed");
		}
		
		reports.flush();
	}
	
	@AfterClass
	public void tearDown() {
		BrowserConfig.closeBrowser(driver);
	}

}
