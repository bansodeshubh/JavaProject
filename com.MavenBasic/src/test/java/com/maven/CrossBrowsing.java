// package com.maven;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Parameters;

// import com.microsoft.edge.seleniumtools.EdgeDriver;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class CrossBrowsing {
// 	 static WebDriver driver;

// 	@Parameters("browser")
// 	@BeforeClass
// 	public static void openBrowser(String browser) {
// 		if (browser.equalsIgnoreCase("chrome")) {
// 			WebDriverManager.chromedriver().setup();
// 			driver = new ChromeDriver();
// 		} else if (browser.equalsIgnoreCase("edge")) {
// 			WebDriverManager.edgedriver().setup();
// 			driver = new EdgeDriver();
// 		} else if (browser.equalsIgnoreCase("firefox")) {
// 			WebDriverManager.firefoxdriver().setup();
// 			driver = new FirefoxDriver();
// 		}
// 	}
// }