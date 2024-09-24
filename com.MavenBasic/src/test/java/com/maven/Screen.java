// package com.maven;

// import java.io.File;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import com.google.common.io.Files;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class Screen {
// 	public static void main(String[] args) throws Exception {

// 		// 1.Browser and window preparation
// 		WebDriverManager.chromedriver().setup();
// 		WebDriver chrome = new ChromeDriver();
// 		chrome.manage().window().maximize();
// 		chrome.get("https://www.facebook.com");

// 		// 2.Type Casting of TakeScreenshot Interface
// 		TakesScreenshot ts = (TakesScreenshot) chrome;

// 		// 3.Getting the Screenshot
// 		File source = ts.getScreenshotAs(OutputType.FILE);

// 		// 4. Use of currentTimeMillis () for avoiding overriding of SS files
// 		long curTime = System.currentTimeMillis();

// 		// 5.Set(Gives) the path , name and extension to Screenshot
// 		File dest = new File("C:\\Users\\lenovo\\Desktop\\as\\Screenshot" + curTime + ".jpg");

// 		// 6.Copy the browser and provide destination
// 		Files.copy(source, dest);

// 		chrome.quit();
// 	}
// }
