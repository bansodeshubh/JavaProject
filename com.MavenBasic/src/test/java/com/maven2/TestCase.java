package com.maven2;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {
	WebDriver driver;

	@Test
	public void test1() {
//		1) Open the browser
		driver = new ChromeDriver();
 		driver.manage().window().maximize();
	}

	@Test
	public void test2() {
//	2) Enter the URL “http://practice.automationtesting.in/”
		driver.get("http://practice.automationtesting.in/");
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://practice.automationtesting.in/";
		Assert.assertEquals(actualurl, expectedurl);
	}

	@Test
	public void test3() throws InterruptedException {
//	3) Click on Shop Menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://practice.automationtesting.in/shop/";
		Assert.assertEquals(actualurl, expectedurl);
	}

	@Test
	public void test4() throws InterruptedException {
//	4) Now click on Home menu button
		driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
		Thread.sleep(3000);
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://practice.automationtesting.in/";
		Assert.assertEquals(actualurl, expectedurl);
	}

	@Test
	public void test5() throws InterruptedException {
//	5) Test whether the Home page has Three Sliders only
		WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[1]/div[1]/img"));
		Thread.sleep(3000);
		WebElement arrow1 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6-arrow-next\"]/img"));
		arrow1.click();
		WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[2]/div[1]/img"));
		Thread.sleep(3000);
		WebElement arrow2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6-arrow-next\"]/img"));
		arrow2.click();
		WebElement slider3 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[3]/div[1]/img"));
		List<WebElement> slider = new ArrayList<WebElement>();
		slider.add(slider1);
		slider.add(slider2);
		slider.add(slider3);
		Thread.sleep(3000);
		int actual = slider.size();  //3
		int expected = 3;
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void test6() throws InterruptedException {
//	6) The Home page must contains only three sliders
		WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[1]/div[1]/img"));
		Thread.sleep(3000);
		WebElement arrow1 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6-arrow-next\"]/img"));
		arrow1.click();
		WebElement slider2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[2]/div[1]/img"));
		Thread.sleep(3000);
		WebElement arrow2 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6-arrow-next\"]/img"));
		arrow2.click();
		WebElement slider3 = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[3]/div[1]/img"));
		List<WebElement> slider = new ArrayList<WebElement>();
		slider.add(slider1);
		slider.add(slider2);
		slider.add(slider3);
		Thread.sleep(3000);
		boolean actual = slider.size()==3;  //true condition
		boolean expected = slider.size()!=3 ; //false condition
		Assert.assertTrue(actual!=expected, "The Home page must contains only three sliders");
		driver.close();
	}
}




