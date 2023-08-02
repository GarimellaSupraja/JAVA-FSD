package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
@SuppressWarnings("unused")
public class Ecommerce {
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before automatic testing is started..");
	}
	WebDriver driver;
	@Test(groups = "Chrome")
	public void LaunchChrome() {
		System.out.println("Automatic testing through Chrome Browser..");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(groups = "Chrome", dependsOnMethods = "LaunchChrome")	
	public void chromeTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
       //To find the load time and print on console
		System.out.println("The title of the page is :" + driver.getTitle());
		System.out.println("Flipkart Page is Loaded..");
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime);
		//closes the signup page
		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed th singup activity..");
		// searching for iPhone 13
		//driver.findElement(By.className("_3704LK")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iPhone 13");
		System.out.println("Inserted the keyword in Search Box..");
		//driver.findElement(By.className("L0Z3Pu")).click();
		driver.findElement(By.cssSelector(".L0Z3Pu > svg")).click();
		System.out.println("Clicked On Search Icon..");
		//Loading Image
		String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		driver.get(url);
		//Identify image
		WebElement i = driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img"));
		//Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		// verify if status is true
		if (p) {
			System.out.println("Image is Loaded");
		} else {
			System.out.println("Image is not Loaded");
		}
		// Load Time of iphone13 page
		System.out.println("The title of the page is :" + driver.getTitle());
		Long loadtime1 = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Loading Time : " + loadtime1);
		// Scrolling
		try {
			long lastHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (Long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
	        //scroll down
			if (lastHeight > 0)
				System.out.println("Scrolled & Height of Page : " + lastHeight);
			else
				System.out.println("Not Scrolled");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	//Firefox browser
	@Test(groups = "Firefox")
	public void LaunchFirefox() {
		System.out.println("Automatic testing through Firefox Browser..");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\lenovo\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe");
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void firefoxTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		 //To find the load time and print on console
		System.out.println("The title of the page is :" + driver.getTitle());
		System.out.println("Flipkart Page is Loaded..");
		Long loadtime = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the website is :- " + loadtime);
		//closes the signup page
		driver.findElement(By.xpath("//button[contains(.,'✕')]")).click();
		System.out.println("Closed the singup activity..");
		// searching for iPhone 13
		//driver.findElement(By.className("_3704LK")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iPhone 13");
		System.out.println("Inserted the keyword in Search Box..");
		//driver.findElement(By.className("L0Z3Pu")).click();
		driver.findElement(By.cssSelector(".L0Z3Pu > svg")).click();
		System.out.println("Clicked On Search Icon..");
		//Loading Image
		String url = "https://www.flipkart.com/search?q=iphone%2013&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off";
		driver.get(url);
		//Identify image
		WebElement i = driver.findElement(By.xpath(
				"/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div/div/img"));
		//Javascript executor to check image
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

		// verify if status is true
		if (p) {
			System.out.println("Image is Loaded");
		} else {
			System.out.println("Image is not Loaded");
		}
		// Load Time of iphone13 page
		System.out.println("The title of the page is :" + driver.getTitle());
		Long loadtime1 = (Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Loading Time : " + loadtime1);
		// Scrolling
		try {
			long lastHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				long newHeight = (Long) ((JavascriptExecutor) driver)
						.executeScript("return document.body.scrollHeight");
				if (newHeight == lastHeight) {
					break;
				}
				lastHeight = newHeight;
			}
			//scroll down
			if (lastHeight > 0)
				System.out.println("Scrolled & Height of Page : " + lastHeight);
			else
				System.out.println("Not Scrolled");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Testing is Done!");
	}

}