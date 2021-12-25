package com.maven2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.microsoft.edge.seleniumtools.EdgeDriver;

public class CrossBrowsing {
	static WebDriver driver ;

	@Parameters("browser")
 @BeforeClass
public static void openBrowser (String browser) {
	if (browser.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver= new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")) {
		driver= new FirefoxDriver();
	}
	}
	
}

