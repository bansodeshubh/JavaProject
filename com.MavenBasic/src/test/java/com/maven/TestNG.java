package com.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.maven2.CrossBrowsing;

public class TestNG {
public static WebDriver driver;
	
	@BeforeClass	
	public void openBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Sep_Mrng_2021_JavaAutomation\\TestNGFramework\\drivers\\chromedriver.exe");
		// driver=new ChromeDriver();
		CrossBrowsing.openBrowser("edge");
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyHomePageTitle() {
	  String expectedTitle="Automation Practice Site";
	  String actualTitle=driver.getTitle();
	 Assert.assertEquals(actualTitle, expectedTitle);
 	}
	
	@Test
	public void verifyNewArrivalsDisplayed() {
		boolean arrivalsActual=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-1-1-0\"]/h2")).isDisplayed();	
		Assert.assertTrue(arrivalsActual);
 	}
	
	@Test
	public void verifyFirstBookTitle() {
		String expectedTitleBook="Selenium Ruby";
		String actualTitleBook=driver.findElement(By.xpath("//h3[text()='Selenium Ruby']")).getText();	
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
 	}
	
  	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
