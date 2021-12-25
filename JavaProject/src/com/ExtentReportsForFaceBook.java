package com;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsForFaceBook {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	static public void setupExtentEnv() {
		
	    htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
		htmlreporter.config().setDocumentTitle("Facebook Log In Report");
		htmlreporter.config().setReportName("Facebook  Log In Testing");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HOST NAME", "LOCALHOST");
		extent.setSystemInfo("Operating System", "WINDOWS 10");   //before test/after test ===> report 
		extent.setSystemInfo("Tester NAME", "Shubham Bansode");   //before class/after class ==> browser
		extent.setSystemInfo("Browser", "Chrome");               //before method/after method ==> test
	}

	
	@BeforeClass
	public void openBrowser() {
		
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void register( Method fb) {   
		
		test = extent.createTest(fb.getName());
	}

	@Test(priority = 2)
	public void verifyHomePageTitle() {
		String expectedTitle = "Facebolog in or sign up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	} 

	@Test(priority = 1)
	public void verifyFacebookImgDisplayed() {
		boolean arrivalsActual = driver.findElement(By.xpath("//img[@alt='Facebook']"))
				.isDisplayed();
		Assert.assertTrue(arrivalsActual);
	}

	@Test
	public void verifyLogIn() {
		String expectedlogin = "Log In";
		String actuallogin = driver.findElement(By.xpath("//*[text()='Log In']")).getText();
		Assert.assertEquals(actuallogin, expectedlogin);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED is=" + result.getName()); 
			test.log(Status.FAIL, "TEST CASE FAILED is=" + result.getThrowable());
			String screenshotpath = ScreenShot.getScreenshot(driver, result.getName()); 
			test.addScreenCaptureFromPath(screenshotpath);
		
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SkIPPED:" + result.getName());
			test.log(Status.SKIP, "TEST CASE FAILED is" + result.getThrowable());
		
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED:" + result.getName());
		}
	
	}
	
	@AfterClass
	public void browserTeardown() {
		driver.quit();
	}
	@AfterTest
	public void cleanup() {
		extent.flush();

	}
}
